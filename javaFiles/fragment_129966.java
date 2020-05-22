@Override public void contextInitialized(ServletContextEvent sce) {
new Thread(new Runnable() {
    @Override
    public void run() {
        executeprocess();
    }
}).start();}