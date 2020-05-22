public Driver() {
    String aType = espertest.dummy.A.class.getName();
    Configuration cepConfig = new Configuration();
    cepConfig.addEventType("A",aType);
    EPServiceProvider epService = EPServiceProviderManager.getProvider("DummyProvider", cepConfig);
    Consumer c = new Consumer(epService);
    Producer p = new Producer(epService);
}