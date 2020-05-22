List<Transport> transports = new ArrayList<Transport>(2);
    transports.add(new WebSocketTransport(new StandardWebSocketClient()));
    transports.add(new RestTemplateXhrTransport());
    SockJsClient sockJsClient = new SockJsClient(transports);
    WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
    stompClient.setMessageConverter(new StringMessageConverter());
    StompSession session = null;
    DefaultStompFrameHandler stompHandler = new DefaultStompFrameHandler();
    try {
        session = stompClient.connect(WEBSOCKET_URI, new MyStompSessionHandler()).get(1, TimeUnit.SECONDS);
        session.subscribe("/topic" + "/channel", stompHandler);
        // do your stuff
        ...         
    } finally {
        if (session != null) {
            session.disconnect();
        }
    }