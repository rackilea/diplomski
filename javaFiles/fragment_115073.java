package com.alskor;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.Assert.fail;

public class ProxySetTest {

  @Test
  public void verifyProxyIsNotCachedInJVM() throws IOException {

    tryConnectionToGoogleCom();

    ProxySelector savedSelector = ProxySelector.getDefault();
    java.net.ProxySelector.setDefault(new FixedProxySelector(getInvalidProxyHost(), getInvalidProxyPort()));

    // Next connection will be through the invalid proxy. must fail?
    try {
      tryConnectionToGoogleCom();
      fail("must have failed with an exception because of invalid proxy setting");
    } catch (Exception e) {
      System.out.println("received exception: " + e);
    }

    // clear the proxy setting and try connecting again - must succeed
    java.net.ProxySelector.setDefault(savedSelector);
    // and without proxy again
    tryConnectionToGoogleCom();
  }

  private void tryConnectionToGoogleCom() throws IOException {
    URL url = new URL("http://google.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.connect();
  }

  private int getInvalidProxyPort() {
    return 1234;
  }

  private String getInvalidProxyHost() {
    return "asd";
  }
}