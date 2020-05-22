@Bean
  public BrokerService broker() throws Exception {
    BrokerService broker = new BrokerService();
    broker.addConnector("tcp://localhost:61616");
    broker.setPersistent(false);
    return broker;
  }