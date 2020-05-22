private static void findFormatters() {
    final LogManager manager = LogManager.getLogManager();
    synchronized (manager) {
        final Enumeration<String> e = manager.getLoggerNames();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }    
}