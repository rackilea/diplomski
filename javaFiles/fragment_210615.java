public class UserContextMapper implements ContextMapper {

    private static ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});

    public Object mapFromContext(Object ctx) {
        Class<User> clazz = User.class;
        LdapTemplate ldapTemplate = (LdapTemplate) appContext.getBean("ldapTemplate");

        User user = ldapTemplate.getObjectDirectoryMapper().mapFromLdapDataEntry((DirContextOperations) ctx, clazz);
        return user;
    }
}