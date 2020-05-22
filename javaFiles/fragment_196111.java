package com.example.test;

public class MyJettyServlet extends WebSocketServlet {
  @Override
  public void configure(WebSocketServletFactory factory) {
    factory.register(ServerSide.class);
  }
}