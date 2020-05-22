Class MyClass{
private static ConfigurableApplicationContext context = null;
private static JobLauncher jobLauncher = null;

static{
    String[] springConfig = {BatchTokeniserConstants.SPRING_CONFIG_FILE_NAME};
        try {
            context = new ClassPathXmlApplicationContext(springConfig);
            jobLauncher = (JobLauncher) context.getBean("jobLauncher");
            BatchTokeniserUtils.loadSystemVaiables();
        } catch (BeansException e) {

        }
     }      
}