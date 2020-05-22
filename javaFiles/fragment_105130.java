protected void handleMessage(Message msg) {
    lock.lock();
    try {
        if (!((String) msg.getObject()).matches("IP_RESPONSE:[0-9.]*"))
            return;
        logger.debug("Received answer from " + msg.getObject());
        String ip = ((String) msg.getObject()).replaceAll("IP_RESPONSE:", "");
        // externalHostIps.add(ip);
        NodeAddress currentAddress = new NodeAddress(ip, msg.getSrc());
        externalNodes.put(ip, currentAddress);
        logger.debug("Signalling all threads");
        allReceived.signalAll();
    } finally {
        lock.unlock();
    }
}