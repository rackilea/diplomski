WebSocketClient transport = new StandardWebSocketClient();
WebSocketStompClient stompClient = new WebSocketStompClient(transport);
MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
stompClient.setMessageConverter(converter);
StompSessionHandler handler = new WSClient(); //custom implementation
String url = "ws://{URL}/ws/websocket";
stompClient.connect(url, handler);