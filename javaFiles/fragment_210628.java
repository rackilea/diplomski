ArrayList<Protocol> protocolList = new ArrayList<Protocol>();
protocolList.add(Protocol.HTTP_1_1);

OkHttpClient okHttpClient = new OkHttpClient();
okHttpClient.setProtocols(protocolList);

RestAdapter restAdapter = new RestAdapter.Builder()
    .setEndpoint(API_URL)
    .setClient(new OkClient(okHttpClient))
    .build();