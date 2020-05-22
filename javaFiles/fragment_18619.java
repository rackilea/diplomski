public static StompSession createStompWSConnection(String socketURL,StompSessionHandler sessionHandler) throws Exception {
    List<Transport> transports = new ArrayList<Transport>();

    //transports.add(new WebSocketTransport(new StandardWebSocketClient())); 
    //transports.add(new WebSocketTransport(new JettyWebSocketClient()));
    transports.add(new RestTemplateXhrTransport());
    SockJsClient sockJsClient = new SockJsClient(transports);
    WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    //stompClient.setMessageConverter(new Mapp);

    StompSession session = stompClient.connect(socketURL,sessionHandler).get(); //error occurs here
    System.out.println("Session : " + session);
    session.subscribe("/queue/msg",  sessionHandler);
    return session;
}