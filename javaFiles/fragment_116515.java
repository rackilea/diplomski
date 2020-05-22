public class QuartzSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

private SchedulerContext schedulerContext;
private ApplicationContext ctx;

@Override
protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
    Job job = ctx.getBean(bundle.getJobDetail().getJobClass());
    BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(job);
    MutablePropertyValues pvs = new MutablePropertyValues();
    pvs.addPropertyValues(bundle.getJobDetail().getJobDataMap());
    pvs.addPropertyValues(bundle.getTrigger().getJobDataMap());
    if (this.schedulerContext != null) {
        pvs.addPropertyValues(this.schedulerContext);
    }
    bw.setPropertyValues(pvs, true);
    return job;
}

public void setSchedulerContext(SchedulerContext schedulerContext) {
    this.schedulerContext = schedulerContext;
    super.setSchedulerContext(schedulerContext);
}

@Override
public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException {
    this.ctx = applicationContext;
}
}