package com.alskor;

import sun.misc.RegexpPool;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class FixedProxySelector extends ProxySelector {

  private final String host;
  private final int port;

  public FixedProxySelector(String host, int port) {
    this.host = host;
    this.port = port;
  }

  @Override
  public java.util.List<Proxy> select(URI uri) {
    if (uri == null) {
      throw new IllegalArgumentException("URI can't be null.");
    }
    List<Proxy> proxies = new ArrayList<Proxy>();
    SocketAddress addr = new InetSocketAddress(host, port);
    proxies.add(new Proxy(Proxy.Type.SOCKS, addr));
    proxies.add(new Proxy(Proxy.Type.HTTP, addr));

    return proxies;
  }

  @Override
  public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    if (uri == null || sa == null || ioe == null) {
      throw new IllegalArgumentException("Arguments can't be null.");
    }
    throw new RuntimeException(ioe.toString(), ioe);
  }

}