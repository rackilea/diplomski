@Bean
public LdapDaoImpl ldapDao() {
    LdapDaoImpl ldapDao = new LdapDaoImpl();
    ldapDao.setLdapUrl(ldapHost());
    return ldapDao;
}