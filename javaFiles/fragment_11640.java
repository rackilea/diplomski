@Bean
public LdapDaoImpl ldapDao(LdapHost ldapHost) {
    LdapDaoImpl ldapDao = new LdapDaoImpl();
    ldapDao.setLdapUrl(ldapHost);
    return ldapDao;
}