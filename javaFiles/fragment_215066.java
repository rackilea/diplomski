graph = new GraphBuilder()
    .createNode(3).setLabel("3").setDescription("null").add()
    .createNode(2).setLabel("2").setDescription("null").add()
    .createNode(1).setLabel("1").setDescription("Accepted").add()
    .createNode(0).setLabel("0").setDescription("Initial").add()
    // unimplemented start
    .createEdge(2, 1).setLabel("0").add()
    .createEdge(2, 2).setLabel("1").add()
    .createEdge(1, 1).setLabel("0").add()
    .createEdge(1, 3).setLabel("1").add()
    .createEdge(0, 1).setLabel("0").add()
    .createEdge(0, 2).setLabel("1").add()
    // unimplemented end
    .build();