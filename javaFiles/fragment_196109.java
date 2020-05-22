package com.example.websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

public class ServerStarter {
  public static void main( String[] args ) throws Exception {
  Server server = new Server(8080);

  final ServletHolder servletHolder = new ServletHolder(new DefaultServlet());
  final ServletContextHandler context = new ServletContextHandler();

  context.setContextPath("/");
  context.addServlet(servletHolder, "/*");

  server.setHandler(context);
  WebSocketServerContainerInitializer.configureContext(context); 

  server.start();
  server.join(); 
  }
}