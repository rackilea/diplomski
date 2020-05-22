private Session session;

try {
   InitialContext ic = new InitialContext();
   session = (Session)ic.lookup(DefaultEmailManager.JNDI_NAME);

} catch (NamingException e) {
   e.printStackTrace();
}