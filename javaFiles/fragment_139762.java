ZkUtils zk = ZkUtils.apply("zkHost:2181", 6000, 6000, true);
List<Broker> brokers = JavaConversions.seqAsJavaList(zk.getAllBrokersInCluster());
for (Broker broker : brokers) {  
    //assuming you do not enable security    
    System.out.println(broker.getBrokerEndPoint(SecurityProtocol.PLAINTEXT).host());
}
zk.close();