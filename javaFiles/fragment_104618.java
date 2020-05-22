public <T> void startSignalR(String transport, String serverUrl, final String userName, final Class<T> tClass) {

    Platform.loadPlatformComponent(new AndroidPlatformComponent());
    Credentials credentials = new Credentials() {
        @Override
        public void prepareRequest(Request request) {
            request.addHeader(HEADER_KEY_USERNAME, userName);
        }
    };

    mConnection = new HubConnection(serverUrl);
    mConnection.setCredentials(credentials);
    mHub = mConnection.createHubProxy(SERVER_HUB_CHAT);

    if (transport.equals("ServerSentEvents")) {
         mTransport = new ServerSentEventsTransport(mConnection.getLogger());
    } else if (transport.equals("LongPolling")) {
         mTransport = new LongPollingTransport(mConnection.getLogger());
    }

    mAwaitConnection = mConnection.start(mTransport);

    try {
        mAwaitConnection.get();
    } catch (InterruptedException e) {      
        e.printStackTrace();      
        return;
    } catch (ExecutionException e) { 
        e.printStackTrace();
        return;
    }

    mHub.on("broadcastMessage",
            new SubscriptionHandler1<Object>() {
                @Override
                public void run(final Object msg) {
                    final String finalMsg;
                    Gson gson = new Gson();
                    Object object = gson.fromJson(msg.toString(), tClass);
                    Field[] fields = object.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        try {
                            System.out.println("Value = " + fields[i].get(object));                                
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }                        
                }
            }
            , Object.class);

    ...
}