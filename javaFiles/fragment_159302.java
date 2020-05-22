@Bean
public JobDetailFactoryBean jobDetailFactoryBean(){
    JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
    jobDetailFactoryBean.setJobClass(MyDetailQuartzJobBean.class);
    Map map=new HashMap<>();
    map.put("targetObject","quartzRemoteProject");
    map.put("targetMethod","run");
    jobDetailFactoryBean.setJobDataAsMap(map);
    jobDetailFactoryBean.setDurability(true);
    return jobDeta
}