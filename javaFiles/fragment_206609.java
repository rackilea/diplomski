private Connections.ConnectionRequestListener myConnectionRequestListener =
        new Connections.ConnectionRequestListener() {
            @Override
            public void onConnectionRequest(String remoteEndpointId, String
                    remoteEndpointName, byte[] bytes) {
                NearbyClient.this.onConnectionRequest(remoteEndpointId,
                        remoteEndpointName, bytes);
            }
        };
private Connections.EndpointDiscoveryListener myEndpointDiscoveryListener =
        new Connections.EndpointDiscoveryListener() {
            @Override
            public void onEndpointFound(String endpointId,
                                        String serviceId,
                                        String name) {
                NearbyClient.this.onEndpointFound(endpointId,serviceId,
                        name);
            }

            @Override
            public void onEndpointLost(String remoteEndpointId) {
                NearbyClient.this.onEndpointLost(remoteEndpointId);
            }
        };