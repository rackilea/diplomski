public static void main(String[] args) {
    SpringApplication application = new SpringApplication(DemoApplication.class);
    Properties properties = new Properties();
    properties.put("lambda.application", "true");
    application.setDefaultProperties(properties);
    application.run(args);
}