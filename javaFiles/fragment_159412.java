static MultiThreadedHttpConnectionManager connectionManager = 
            new MultiThreadedHttpConnectionManager();
// HttpClient instance that can be shared across threads and create multiple connections
static HttpClient client = new HttpClient(connectionManager);

// ... and when it's time to close connections
connectionManager.shutdown();