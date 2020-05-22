final SimpleHttpConnectionManager connectionManager = 
            new SimpleHttpConnectionManager();
final HttpClient client = new HttpClient(connectionManager);

// ... and when it's time to close the connection from another thread
connectionManager.shutdown();