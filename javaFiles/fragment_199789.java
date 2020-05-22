BrokerService broker = new BrokerService();
broker.addConnector(Constants.ACTIVEMQ_URL);
broker.setPersistent(false);
SystemUsage systemUsage = brokerService.getSystemUsage();
systemUsage.getStoreUsage().setLimit(1024 * 1024 * 8);
systemUsage.getTempUsage().setLimit(1024 * 1024 * 8);
broker.start();