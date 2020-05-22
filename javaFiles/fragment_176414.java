private String getIP(){
    MessageContext mc = wsContext.getMessageContext();
    HttpExchange exchange = (HttpExchange)mc.get("com.sun.xml.internal.ws.http.exchange");
    System.out.print(exchange.getRemoteAddress().getAddress().getHostAddress());
    return exchange.getRemoteAddress().getAddress().getHostAddress();
}