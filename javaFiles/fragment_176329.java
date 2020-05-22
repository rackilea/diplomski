OrientGraph graph = new OrientGraph("remote:localhost/blah","root","*****");
System.out.println("Connected to the db.");
try { Vertex messageLog = graph.addVertex("class:MessageLog");

      System.out.println("Created new vertex : " + messageLog.toString());
      messageLog.setProperty("messageId", null);
      graph.commit();
} catch(Exception e) {
  graph.rollback();
}
finally {
  graph.shutdown();
}