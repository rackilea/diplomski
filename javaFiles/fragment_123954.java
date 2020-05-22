private String pickBestNodeId(List<Node> nodes) {
    String bestNodeId = null;
    // Find a nearby node or pick one arbitrarily
    for (Node node : nodes) {
        if (node.isNearby()) {
            return node.getId();
         }
         bestNodeId = node.getId();
    }
    return bestNodeId;
}

public boolean send(File f) {
    GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
    // Request access only to the Wearable API
        .addApi(Wearable.API)
        .build();
    mGoogleApiClient.blockingConnect();
    Channel channel = openChannel(mGoogleApiClient, pickBestNodeId(Wearable.NodeApi.getConnectedNodes(mGoogleApiClient).await()), "/your/arbitrary/application/specific/path/").await(); //NOTE THE PATH IS ARBITRARY, IT CAN BE WHATEVER YOU WANT. IT DOES NOT POINT TO ANYTHING, AND CAN EVEN BE LEFT WITH WHAT I HAVE.
    boolean didSend = channel.sendFile(mGoogleApiClient, f.toURI()).await().isSuccess();
    channel.close(mGoogleApiClient);
    mGoogleApiClient.disconnect();
    return didSend;
}