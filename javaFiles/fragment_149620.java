Config conf = new Config();
conf.setDebug(true);
conf.setNumWorkers(20);
String inputjar="C:/storm/bin/Main.jar";
System.setProperty("storm.jar",inputjar);
StormTopology aTopology = ATopologyBuilder.buildTopology(zkHost).createTopology();
StormTopology bTopology = BTopologyBuilder.buildTopology(zkHost).createTopology();
StormSubmitter.submitTopology("A", conf, aTopology);
StormSubmitter.submitTopology("B", conf, bTopology);