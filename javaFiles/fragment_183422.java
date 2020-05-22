@Bean
public Session session(){
    SessionConnector connector=
      new SessionConnector(url,username,password,environment);
    Session session= connector.getSession();

    // This is modified initialization code
    Listener listener = new Listener( session );
    session.registerListener(listener);

    return session;
}