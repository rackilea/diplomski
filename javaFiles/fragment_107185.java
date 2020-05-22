Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    closeable.close();
    logger.info("Close closeable.");
    executorPool.shutdown();
    logger.info("Shutdown executorPool");
 }));