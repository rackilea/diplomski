try {
    AbandonedConnectionCleanupThread.shutdown();
} catch (InterruptedException e) {
    logger.warn("SEVERE problem cleaning up: " + e.getMessage());
    e.printStackTrace();
}