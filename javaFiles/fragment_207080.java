Runtime.getRuntime().addShutdownHook(new Thread() {
    @Override
    public void run() {
        try {
            //Connect to controlSocket and send STOP command
            ZMQ.Socket peer = context.socket(ZMQ.PUSH);
            peer.connect(CONTROL_ENDPOINT);
            peer.send(STOP_MESSAGE, 0);
            peer.close();
        } catch (Exception ex) {
            logger.error("Failed to stop service", ex);
            System.exit(1);
        }
   }
});