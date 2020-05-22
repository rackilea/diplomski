@Bean(name = "jobDetailFactoryBean")
public BeanInvokingJobDetailFactoryBean detailFactoryBean(){
    BeanInvokingJobDetailFactoryBean bean = new BeanInvokingJobDetailFactoryBean ();
    bean.setTargetBean("quartzRemoteProject");
    bean.setTargetMethod ("run");
    bean.setDurable(true);
    bean.setShouldRecover(true);
    bean.setConcurrent (false);
    return bean;
}