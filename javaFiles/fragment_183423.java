@Bean
public Session session(){
    SessionConnector connector=
      new SessionConnector(url,username,password,environment);
    Session session= connector.getSession();

    return session;
}

@Bean
public Listener listener(){
   Session session = session( );
   Listener listener = new Listener( session );

   session.registerListener( listener );

   return listener;
}