class MyJob implements Job {
    ...
    public void execute(final JobExecutionContext context) throws JobExecutionException {
        // Process @Autowired injection for the given target object, based on the current web application context. 
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        ...
    }

}