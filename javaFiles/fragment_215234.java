setUp() {
    initialize connection manager;
    initialize connection by creating client;
  }

  tearDown() {
    close connection if necessary;
    close connection manager if necessary;
  }

  testConnectionOpen() {
    assert that connection is open;
    pause for time of idle connection timeout - 1 second;
    assert that connection **is still open**;
  }

  testConnectionClosed() {
    assert that connection is open;
    pause for time of idle connection timeout + 1 second;
    assert that connection **is closed**;
  }