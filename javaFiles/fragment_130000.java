package com.sapbasu.javastudy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class TLSServerClientTest {

  private static final int SERVER_PORT = 8444;
  private static final String TLS_VERSION = "TLSv1.2";
  private static final int SERVER_COUNT = 1;
  private static final String SERVER_HOST_NAME = "127.0.0.1";
  private static final String TRUST_STORE_NAME = "servercert.p12";
  private static final char[] TRUST_STORE_PWD = new char[] {'a', 'b', 'c', '1',
      '2', '3'};
  private static final String KEY_STORE_NAME = "servercert.p12";
  private static final char[] KEY_STORE_PWD = new char[] {'a', 'b', 'c', '1',
      '2', '3'};

  @Test
  public void whenClientSendsServerRequest_givenServerIsUp_returnsHelloWorld()
      throws Exception {
    TLSServer server = new TLSServer();
    TLSClient client = new TLSClient();

    System.setProperty("javax.net.debug", "ssl");

    ExecutorService serverExecutor = Executors.newFixedThreadPool(SERVER_COUNT);
    serverExecutor.submit(() -> {
      try {
        server.serve(SERVER_PORT, TLS_VERSION, TRUST_STORE_NAME,
            TRUST_STORE_PWD, KEY_STORE_NAME, KEY_STORE_PWD);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    try {
      String returnedValue = client.request(
          InetAddress.getByName(SERVER_HOST_NAME), SERVER_PORT, TLS_VERSION,
          TRUST_STORE_NAME, TRUST_STORE_PWD, KEY_STORE_NAME, KEY_STORE_PWD);
      assertEquals("Hello World!", returnedValue);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
}