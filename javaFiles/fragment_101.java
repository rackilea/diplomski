@Bean
public MethodInvokingFactoryBean methodInvokingFactoryBean(@Value("${log.properties}") String location) {
    MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
    methodInvokingFactoryBean.setTargetClass(Log4jConfigurer.class);
    methodInvokingFactoryBean.setTargetMethod("initLogging");
    methodInvokingFactoryBean.setArguments(new Object[]{location});
    return methodInvokingFactoryBean;
}