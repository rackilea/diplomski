ImmutableSettings.Builder settings
            = ImmutableSettings.builder();
settings.put("node.name", "nameOfTheNode"); // set the name to reuse the node
settings.put("path.data", "/opt/elasticsearch/data"); // the data will be stored in this folder

Node node = NodeBuilder.nodeBuilder()
        .settings(settings)
        .clusterName("nameOfTheCluser")
        .data(true) // make the node store data
        .node()
        .start();