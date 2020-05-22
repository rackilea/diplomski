public int depthOfQueue() throws MQException {
        queueManager = createQueueManager();
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT | MQConstants.MQOO_INQUIRE;
        MQQueue queue = queueManager.accessQueue(queueName, openOptions);
        int depth = queue.getCurrentDepth();
        queueManager.disconnect();
        queue.close();
        return depth;
    }