CloneCommand cloneCommand = Git.cloneRepository();
cloneCommand.setTransportConfigCallback( new TransportConfigCallback() {
  @Override
  public void configure( Transport transport ) {
    if( transport instanceof SshTransport ) {
      SshTransport sshTransport = ( SshTransport )transport;
      sshTransport.setSshSessionFactory( ... );
    }
  }
} );