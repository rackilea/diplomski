@Configuration
public class LdapTemplateConfig {

    private final Logger log = LoggerFactory.getLogger(LdapTemplateConfig.class);

    @Bean(name = "ldapTemplate")
    // @Scope("singleton")
    public LdapTemplate ldapTemplate() {
        LdapTemplate ldapTemplate = new LdapTemplate(ldapContextSource());
        return ldapTemplate;
    }

    @Bean(name = "contextSource")
    // @Scope("singleton")
    public LdapContextSource ldapContextSource() {

        String url = "ldap://127.0.0.1:389";
        String base = "DC=intranet,DC=demo,DC=com";

        if (isConfigurationValid(url, base)) {
            LdapContextSource ldapContextSource = new LdapContextSource();
            ldapContextSource.setUrl(url);
            ldapContextSource.setBase(base);
            ldapContextSource.setUserDn(
                    "CN=Test User,OU=Common Users OU,OU=RDP enabled Users OU,DC=intranet,DC=demo,DC=com");
            ldapContextSource.setPassword("password");
            ldapContextSource.setReferral("follow");
            // lcs.setPooled(false);
            // lcs.setDirObjectFactory(DefaultDirObjectFactory.class);
            ldapContextSource.afterPropertiesSet();
            return ldapContextSource;
        }
        return null;
    }

    public boolean isConfigurationValid(String url, String base) {
        if ((url == null) || url.isEmpty() || (base == null) || base.isEmpty()) {
            log.error("Warning! Your LDAP server is not configured.");
            log.info("Did you configure your LDAP settings in your application.yml?");
            return false;
        } else {
            return true;
        }
    }
}




@Service
public class LDAPServiceImpl {

    private final Logger log = LoggerFactory.getLogger(LDAPServiceImpl.class);

    @Autowired
    LdapTemplate ldapTemplate;

    public User getUserDetails(String userName) {
        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectclass", "person")).and(new EqualsFilter("employeeID", "700335"));
        List<User> users = ldapTemplate.search("", filter.encode(), new UaserAttributesMapper());
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;

        // List<User> list =
        // ldapTemplate.search(query().where("sAMAccountName").is("a.keskempes"),
        // new UserAttributesMapper());
        // if ((list != null) && !list.isEmpty()) {
        // return list.get(0);
        // }
        // return null;

    }

    private class UaserAttributesMapper implements AttributesMapper<User> {

        @Override
        public User mapFromAttributes(Attributes attributes) throws NamingException {
            User user;
            if (attributes == null) {
                return null;
            }
            user = new User();

            if (attributes.get("objectclass") != null) {
                user.setObjectclass(attributes.get("objectclass").get().toString());
            }
            if (attributes.get("distinguishedname") != null) {
                user.setDistinguishedname(attributes.get("distinguishedname").get().toString());
            }
            if (attributes.get("userPassword") != null) {
                user.setUserPassword(attributes.get("userPassword").get().toString());
            }
            if (attributes.get("cn") != null) {
                user.setCn(attributes.get("cn").get().toString());
            }
            if (attributes.get("telephoneNumber") != null) {
                user.setTelephoneNumber(attributes.get("telephoneNumber").get().toString());
            }
            // if (attributes.get("lastlogoff") != null) {
            // // user.setLastlogoff(DateTimeFormat.forPattern("yyyy-MM-dd
            // // HH:mm:ss")
            // //
            // .parseDateTime(attributes.get("lastlogoff").get().toString()));
            // DateTimeFormatter formatter =
            // DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
            // DateTime dt =
            // formatter.parseDateTime(attributes.get("lastlogoff").get().toString());
            // user.setLastlogoff(new DateTime(
            //
            // dt
            //
            // ));
            // }
            if (attributes.get("userprincipalname") != null) {
                user.setUserprincipalname(attributes.get("userprincipalname").get().toString());
            }
            if (attributes.get("department") != null) {
                user.setDepartment(attributes.get("department").get().toString());
            }
            if (attributes.get("company") != null) {
                user.setCompany(attributes.get("company").get().toString());
            }
            if (attributes.get("mail") != null) {
                user.setMail(attributes.get("mail").get().toString());
            }
            if (attributes.get("streetAddress") != null) {
                user.setStreetAddress(attributes.get("streetAddress").get().toString());
            }
            if (attributes.get("st") != null) {
                user.setSt(attributes.get("st").get().toString());
            }
            if (attributes.get("postalCode") != null) {
                user.setPostalCode(attributes.get("postalCode").get().toString());
            }
            if (attributes.get("l") != null) {
                user.setL(attributes.get("l").get().toString());
            }
            if (attributes.get("description") != null) {
                user.setDescription(attributes.get("description").get().toString());
            }
            if (attributes.get("c") != null) {
                user.setC(attributes.get("c").get().toString());
            }
            if (attributes.get("countryCode") != null) {
                user.setCountryCode(attributes.get("countryCode").get().toString());
            }
            if (attributes.get("cn") != null) {
                user.setCn(attributes.get("cn").get().toString());
            }
            if (attributes.get("sn") != null) {
                user.setSn(attributes.get("sn").get().toString());
            }
            if (attributes.get("employeeID") != null) {
                user.setEmployeeId(attributes.get("employeeID").get().toString());
            }
            if (attributes.get("lastLogon") != null) {
                // user.setLastLogon(DateTimeFormat.forPattern("yyyy-MM-dd
                // HH:mm:ss")/*
                // .parseDateTime(attributes.get("lastLogon").get().toString()));*/

                DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
                DateTime dt = formatter.parseDateTime(attributes.get("lastLogon").get().toString());
                user.setLastLogon(new DateTime(

                        dt

                ));
            }
            if (attributes.get("memberof") != null) {
                user.setMemberof(attributes.get("memberof").get().toString());
            }
            if (attributes.get("givenname") != null) {
                user.setGivenname(attributes.get("givenname").get().toString());
            }
            if (attributes.get("logoncount") != null) {
                user.setLogoncount(attributes.get("logoncount").get().toString());
            }
            if (attributes.get("displayName") != null) {
                user.setDisplayname(attributes.get("displayName").get().toString());
            }

            return user;
        }
    }

}