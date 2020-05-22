@SuppressWarnings("unchecked")
    public MQQueueManager createQueueManager() throws MQException {
        MQEnvironment.port = port;
        MQEnvironment.hostname = host;
        MQEnvironment.channel = channel; 
        MQEnvironment.properties.put(MQConstants.TRANSPORT_PROPERTY, MQConstants.TRANSPORT_MQSERIES);
        return new MQQueueManager(queueManagerName);
    }