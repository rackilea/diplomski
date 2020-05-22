public static void main(String[] args) throws Exception {
    Random rnd = new Random();
    logger.addHandler(new SharedFileHandler());
    String id = ManagementFactory.getRuntimeMXBean().getName();
    for (int i = 0; i < 600; i++) {
        logger.log(Level.INFO, id);
        Thread.sleep(rnd.nextInt(100));
    }
}