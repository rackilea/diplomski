import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.DefaultPoolableLdapConnectionFactory;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.ldap.client.template.LdapConnectionTemplate;
import org.apache.directory.ldap.client.template.PasswordWarning;
import org.apache.directory.ldap.client.template.exception.PasswordException;

private String ldapAuthenticationApacheDsFlow(final SlingHttpServletRequest request) {
    String status = "";
    try {
        LdapConnectionConfig config = new LdapConnectionConfig();
        config.setLdapHost("localhost");
        config.setLdapPort(10389);
        config.setName("uid=admin,ou=system");
        config.setCredentials("secret");
        final DefaultPoolableLdapConnectionFactory factory = new DefaultPoolableLdapConnectionFactory(config);
        final LdapConnectionPool pool = new LdapConnectionPool(factory);
        pool.setTestOnBorrow(true);
        final LdapConnectionTemplate ldapConnectionTemplate = new LdapConnectionTemplate(pool);
        final String uid = request.getParameter("externalId");
        final String password = request.getParameter("externalPassword");
        final PasswordWarning warning = ldapConnectionTemplate.authenticate(
                "ou=Users,dc=example,dc=com", "(uid=" + uid +")", SearchScope.SUBTREE,  password.toCharArray());
        status = "User credentials authenticated";
        if(warning != null) {
            status = status + " \n Warning!!" +warning.toString();
        }
    } catch(final PasswordException e) {
        status = e.toString();
        e.printStackTrace();
    }
    return status;
}