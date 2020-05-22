@Override
public void contextDestroyed(ServletContextEvent sce) {

    log.info("Scheduler entered contextDestroyed");

    if (listChecker != null) {
        listChecker.shutdownNow();
        log.info("waiting [60 seconds] for collector threads to finsih");
        try {
            listChecker.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }   

    log.info("Scheduler finished contextDestroyed");
}