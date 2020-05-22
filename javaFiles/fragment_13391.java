import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.PagedResultsControl;
import javax.naming.ldap.PagedResultsResponseControl;

public class LDAP {

    public static void main(String[] args) {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        InitialLdapContext ldapContext = null;
        Hashtable ldapEnv = new Hashtable(11);

        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ldapEnv.put(Context.PROVIDER_URL, "ldaps://HOST:636");

        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        ldapEnv.put(Context.SECURITY_PROTOCOL, "ssl");
        ldapEnv.put(Context.SECURITY_PRINCIPAL, "ADMIN");
        ldapEnv.put(Context.SECURITY_CREDENTIALS, "PASSWORD");
        ldapEnv.put("java.naming.ldap.attributes.binary", "objectGUID");

        byte[] cookie = null;

        String baseName = "BASENAME";
        try {
            ldapContext = new InitialLdapContext(ldapEnv, new Control[] { new PagedResultsControl(1, Control.NONCRITICAL) });
            SearchControls ctls = new SearchControls();
            ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            ctls.setCountLimit(1);
            String[] attrs = new String[] { "objectGUID", "cn", "userParameters" };
            ctls.setReturningAttributes(attrs);
            NamingEnumeration<SearchResult> e = ldapContext.search(baseName, "(&(objectclass=user)(cn=USERCN))", ctls);
            if (e.hasMore()) {
                SearchResult sr = e.next();

                Attribute attr = sr.getAttributes().get("cn");
                if (attr.get() != null) {
                    NamingEnumeration<?> neAttr = attr.getAll();
                    while (neAttr.hasMoreElements()) {
                        String val = neAttr.next().toString();
                        System.out.println(val);
                    }
                }

                attr = sr.getAttributes().get("userParameters");
                if (attr.get() != null) {
                    NamingEnumeration<?> neAttr = attr.getAll();
                    while (neAttr.hasMoreElements()) {
                        String v = neAttr.next().toString();

                        System.out.println("-------------");
                        byte[] val = v.getBytes(StandardCharsets.UTF_16LE);

                        ByteBuffer buffer = ByteBuffer.wrap(val);
                        buffer.order(ByteOrder.LITTLE_ENDIAN);
                        buffer.position(96);
                        char signature = buffer.getChar();
                        System.out.println("Signature : " + signature);

                        if (signature == 'P') {

                            int nbAttrs = (int) buffer.getChar();
                            System.out.println("nbAttrs : " + nbAttrs);

                            for (int i = 0; i < nbAttrs; i++) {

                                System.out.println("\n---- Attribute " + i + " ----");

                                int nameLength = (int) buffer.getChar();
                                System.out.println("nameLength : " + nameLength);

                                int valueLength = (int) buffer.getChar();
                                System.out.println("valueLength : " + valueLength);

                                int type = (int) buffer.getChar();
                                System.out.println("type : " + type);

                                byte[] attrNameTab = new byte[nameLength];
                                buffer.get(attrNameTab);
                                String attrName = new String(attrNameTab, StandardCharsets.UTF_16LE);
                                System.out.println("attrName : " + attrName);

                                byte[] attrValue = new byte[valueLength];
                                buffer.get(attrValue);

                                if (attrName.matches("CtxCfgPresent|CtxCfgFlags1|CtxCallBack|CtxKeyboardLayout|CtxMinEncryptionLevel|CtxNWLogonServer|CtxMaxConnectionTime|CtxMaxDisconnectionTime|CtxMaxIdleTime|CtxShadow")) {

                                    String valueStr = "";
                                    for (byte b : attrValue) {
                                        valueStr += (char) b;
                                    }
                                    Integer valueInt = Integer.parseUnsignedInt(valueStr, 16);
                                    System.out.println("attrValue : " + valueInt);

                                    if (attrName.matches("CtxShadow")) {
                                        switch (valueInt) {
                                        case 0x0:
                                            System.out.println(" -> Disable");
                                            break;
                                        case 0x1000000:
                                            System.out.println(" -> EnableInputNotify");
                                            break;
                                        case 0x2000000:
                                            System.out.println(" -> EnableInputNoNotify");
                                            break;
                                        case 0x3000000:
                                            System.out.println(" -> EnableNoInputNotify");
                                            break;
                                        case 0x4000000:
                                            System.out.println(" -> EnableNoInputNoNotify");
                                            break;
                                        }
                                    } else if (attrName.matches("CtxCfgFlags1")) {
                                        // this field is represented as a bitmask

                                        for (CtxCfgFlagsBitValues en : CtxCfgFlagsBitValues.values()) {
                                            if (en.isBit(valueInt)) {
                                                System.out.println(" -> " + en.name());
                                            }
                                        }
                                    } else if (attrName.matches("CtxMaxConnectionTime|CtxMaxDisconnectionTime|CtxMaxIdleTime")) {
                                        for (CtxCfgFlagsTimeValues en : CtxCfgFlagsTimeValues.values()) {
                                            if (en.getValue() == valueInt.intValue()) {
                                                System.out.println(" -> " + en.name());
                                            }
                                        }
                                    }

                                } else if (attrName.matches("CtxWFHomeDirDrive.*|CtxWFHomeDir.*|CtxWFHomeDrive.*|CtxInitialProgram.*|CtxWFProfilePath.*|CtxWorkDirectory.*|CtxCallbackNumber.*")) {

                                    String str = new String(attrValue, StandardCharsets.US_ASCII);
                                    String valueStr = convertHexToString(str);
                                    valueStr = valueStr.substring(0, valueStr.length() - 1);

                                    if (attrName.matches(".*W$")) {
                                        // handle wide strings
                                        valueStr = new String(new String(valueStr.getBytes(), StandardCharsets.US_ASCII).getBytes(),StandardCharsets.UTF_16LE);
                                        valueStr = valueStr.substring(0, valueStr.length() - 1);
                                    }
                                    System.out.println("attrValue : " + valueStr);
                                }

                            }
                        }
                    }
                }
                Control[] controls = ldapContext.getResponseControls();
                if (controls != null) {
                    for (int i = 0; i < controls.length; i++) {
                        if (controls[i] instanceof PagedResultsResponseControl) {
                            PagedResultsResponseControl prrc = (PagedResultsResponseControl) controls[i];
                            cookie = prrc.getCookie();
                        } else {
                            // Handle other response controls (if any)
                        }
                    }
                }
                ldapContext.setRequestControls(new Control[] { new PagedResultsControl(1, cookie, Control.CRITICAL) });
            }
            while (cookie != null);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (ldapContext != null) {
                try {
                    ldapContext.close();
                } catch (Exception e1) {
                }
            }
        }
    }

    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {
            // grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            // convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            // convert the decimal to character
            sb.append((char) decimal);
        }
        return sb.toString();
    }

    private static enum CtxCfgFlagsBitValues {

        INHERITCALLBACK(0x08000000), 
        INHERITCALLBACKNUMBER(0x04000000), 
        INHERITSHADOW(0x02000000),
        INHERITMAXSESSIONTIME(0x01000000), 
        INHERITMAXDISCONNECTIONTIME(0x00800000), 
        INHERITMAXIDLETIME(0x00400000),
        INHERITAUTOCLIENT(0x00200000), 
        INHERITSECURITY(0x00100000), 
        PROMPTFORPASSWORD(0x00080000),
        RESETBROKEN(0x00040000), 
        RECONNECTSAME(0x00020000), 
        LOGONDISABLED(0x00010000), 
        AUTOCLIENTDRIVES(0x00008000),
        AUTOCLIENTLPTS(0x00004000), 
        FORCECLIENTLPTDEF(0x00002000), 
        DISABLEENCRYPTION(0x00001000),
        HOMEDIRECTORYMAPROOT(0x00000800), 
        USEDEFAULTGINA(0x00000400), 
        DISABLECPM(0x00000200), 
        DISABLECDM(0x00000100),
        DISABLECCM(0x00000080), 
        DISABLELPT(0x00000040), 
        DISABLECLIP(0x00000020), 
        DISABLEEXE(0x00000010),
        WALLPAPERDISABLED(0x00000008), 
        DISABLECAM(0x00000004);

        private int mask;

        CtxCfgFlagsBitValues(int mask) {
            this.mask = mask;
        }

        public boolean isBit(int val) {
            return ((val & mask) == mask);
        }
    }

    private static enum CtxCfgFlagsTimeValues {

        ONE_MINUTE(1625948160), 
        FIVE_MINUTES(-527236096), 
        TEN_MINUTES(-1071183616), 
        FIFTEEN_MINUTES(-1598354176),
        THIRTY_MINUTES(1081547520), 
        ONE_HOUR(-2131872256), 
        TWO_HOURS(14511360), 
        THREE_HOURS(-2134137856),
        ONE_DAY(6039045), 
        TWO_DAYS(12078090);

        private int value;

        CtxCfgFlagsTimeValues(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}