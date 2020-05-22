final Node node = NodeBuilder.nodeBuilder()
            .settings(ImmutableSettings.builder().put("shield.enabled", false))
            .local(true).node();
Client client = node.client();
ClusterHealthResponse response = client.admin().cluster().prepareHealth().get();
System.out.println(response.toString());