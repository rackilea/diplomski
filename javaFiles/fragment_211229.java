@Test
public void addToList() throws NamingException {
   doReturn(true,false).when(enumeration).hasMoreElements();
   doReturn(attr).when(enumeration).nextElement();
   Assert.assertNotNull(ldapQueryDaoImpl.addToList(enumeration));
}