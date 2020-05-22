package com.adamiworks.commonutils.ldap;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 * Authenticates with LDAP Servers. Just using a single UID this class goes deep
 * inside the user's tree and find the full DN for the given UID. It also allows
 * to connect to servers when you don't have the certificate yet... but use this
 * feature at your own risk!
 * 
 * @author Tiago J. Adami
 *
 */
public class LdapUtils {
    private InitialDirContext ldap;
    private String host;
    private int port;
    private boolean useSSL;
    private boolean ignoreCertificates;
    private String basedn;

    public InitialDirContext getLdap() {
        return ldap;
    }

    public boolean isIgnoreCertificates() {
        return ignoreCertificates;
    }

    public void setIgnoreCertificates(boolean ignoreCertificates) {
        this.ignoreCertificates = ignoreCertificates;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getBasedn() {
        return basedn;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    /**
     * Default constructor
     * 
     * @param host
     * @param port
     * @param basedn
     * @param useSSL
     * @param ignoreCertificates
     */
    public LdapUtils(String host, int port, String basedn, boolean useSSL, boolean ignoreCertificates) {
        super();
        this.host = host;
        this.port = port;
        this.useSSL = useSSL;
        this.basedn = basedn;
        this.ignoreCertificates = ignoreCertificates;
    }

    /**
     * Authenticates an user and password from LDAP credentials;
     * 
     * @param uid
     * @param password
     * @return
     * @throws NamingException
     */
    public boolean authenticate(String uid, String password) {
        try {
            String url = getUrl();
            String dn = this.getDnByUid(uid);

            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);

            env.put(Context.SECURITY_AUTHENTICATION, "simple");

            env.put(Context.SECURITY_PRINCIPAL, dn);
            env.put(Context.SECURITY_CREDENTIALS, password);

            if (this.useSSL) {
                env.put(Context.SECURITY_PROTOCOL, "ssl");
            }

            if (this.useSSL && this.ignoreCertificates) {
                env.put("java.naming.ldap.factory.socket", "com.adamiworks.commonutils.ldap.TrustAllCertificatesSSLSocketFactory");
            }

            ldap = new InitialDirContext(env);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return false;
        } catch (NamingException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Returns the url based on SSL or not
     * 
     * @return
     */
    private String getUrl() {
        StringBuilder url = new StringBuilder();

        url.append(this.useSSL ? "ldaps://" : "ldap://");
        url.append(host);
        url.append(":");
        url.append(port);
        return url.toString();
    }

    /**
     * Returns the url based on SSL or not
     * 
     * @return
     */
    private String getUrlWithoutSsl() {
        StringBuilder url = new StringBuilder();
        url.append("ldap://");
        url.append(host);
        return url.toString();
    }

    /**
     * Return LDAP authentication modes allowed by the server
     * 
     * @param url
     * @return
     * @throws NamingException
     */
    public Attributes getLdapAuths() throws NamingException {

        // Create initial context
        DirContext ctx = new InitialDirContext();

        // Read supportedSASLMechanisms from root DSE
        Attributes attrs = ctx.getAttributes(this.getUrl(), new String[] { "supportedSASLMechanisms" });

        System.out.println(attrs);

        return attrs;

    }

    /**
     * Returns the full DN (distinct name) for a given UID
     * 
     * @param uid
     *            the UID name of the user
     * @return full tree path of LDAP
     * @throws NamingException
     */
    @SuppressWarnings("rawtypes")
    public String getDnByUid(String uid) throws NamingException {
        String url = this.getUrlWithoutSsl() + "/" + this.basedn;

        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);

        String ret = "uid=" + uid;
        DirContext ctx = null;

        try {
            // Create initial context
            ctx = new InitialDirContext(env);

            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            NamingEnumeration answer = ctx.search("", "(uid=" + uid + ")", controls);

            while (answer.hasMore()) {
                SearchResult sr = (SearchResult) answer.next();
                ret = sr.getNameInNamespace();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the context when we're done
            ctx.close();
        }

        System.out.println("FULL DN:  " + ret);

        return ret;
    }

}