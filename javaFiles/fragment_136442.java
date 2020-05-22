DseCluster dseCluster = DseCluster.builder()
            .addContactPoint("127.0.0.1")
            .withGraphOptions(new GraphOptions().setGraphName("demo"))
            .build();
DseSession dseSession = dseCluster.newSession();
SimpleGraphStatement s = new SimpleGraphStatement(
            "def v1 = g.V(id1).next()\n" + 
            "def v2 = g.V(id2).next()\n" +
            "v1.addEdge('relates', v2)");
dseSession.executeGraph(s);