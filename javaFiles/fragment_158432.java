public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
  HttpRequest request = (HttpRequest) e.getMessage();
  HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), request);

  InterfaceHttpData data = decoder.getBodyHttpData("fromField1");
  if (data.getHttpDataType() == HttpDataType.Attribute) {
     Attribute attribute = (Attribute) data;
     String value = attribute.getValue()
     System.out.println("fromField1 :" + value);
  }
}