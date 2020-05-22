enum ApplicationContextHolder {
   INSTANCE;
    private ApplicationContext ctx;
    void setApplicationContext(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    ApplicationContext getCtx() {
        return this.ctx;
    }

}


// and a listener (spring boot provides many ways to register one, but the 
// implementation should be something like this):
// The main point is that its managed by spring boot, and hence and access to 
// the application context
class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {           
             ApplicationContextHolder
             .INSTANCE
             .setApplicationContext(event.getApplicationContext());
    }
}