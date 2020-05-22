SshSessionFactory.setInstance( new JschConfigSessionFactory() {
    @Override
    protected void configure( Host host, Session session ) {
      session.setPassword( "password" );
    }
} );
Git.cloneRepository()
  .setURI( "ssh://username@host/path/repo.git" )
  .setDirectory( "/path/to/local/repo" )
  .call();