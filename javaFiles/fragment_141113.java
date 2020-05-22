env.put( "java.naming.ldap.factory.socket", ThreadLocalSocketFactory.class.getName() );
ThreadLocalSocketFactory.set( sslContext.getSocketFactory() );
try {
  ctx = new InitialLdapContext( env, null );
} finally {
  ThreadLocalSocketFactory.remove();
}