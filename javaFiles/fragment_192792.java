SwingWorker<EnvInfoProto, Void> worker = new SwingWorker<EnvInfoProto, Void>() {
    ...
};
worker.execute();
worker.get(15, TimeUnit.SECONDS); 
//will block 15 seconds at most, then throw TimeoutException