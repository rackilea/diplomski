TopologyBuilder builder = new TopologyBuilder();
  Map conf = new HashMap();
  //Map conf = Utils.readStormConfig();
  conf.put(Config.NIMBUS_HOST, "100.0.0.26");
  conf.put(Config.NIMBUS_THRIFT_PORT , 6627 );
  conf.put(Config.STORM_ZOOKEEPER_PORT, 2181 );
  conf.put(Config.TOPOLOGY_WORKERS , 4);

  conf.put("storm.thrift.transport", "backtype.storm.security.auth.SimpleTransportPlugin");