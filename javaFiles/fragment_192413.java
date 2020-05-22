public static void main(String[] args) {
    TopologyBuilder b = new TopologyBuilder();
    // build your topology
    b.setSpout(...);
    b.setBolt(...);

    Config c = new Config();
    c.put(Config.NIMBUS_HOST, "130.211.244.139");
    // not sure you you use 6627; 6123 is default port; if you change the port, just use 6627 of course
    c.put(Config.NIMBUS_THRIFT_PORT, new Integer(6123));

    StormSubmitter.submitTopology("myTopolgyName", conf, b.createTopology());
}