@Bean
public AgiServerThread agiServerThread(){
    AgiServerThread agiServerThread = new AgiServerThread(getDefaultAgiServer());
    agiServerThread.startup();
    return agiServerThread;
}

@Bean
public DefaultAgiServer getDefaultAgiServer(){
    return new DefaultAgiServer(getAsteriskAgiScript());
}

@Bean
public AgiScript getAsteriskAgiScript(){
    return new AsteriskAgi();
}