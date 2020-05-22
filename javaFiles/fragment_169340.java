@Component
public class MailListenerBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private MailListener listener;

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof AbstractJob) {
            final AbstractJob job = (AbstractJob) bean;

            job.registerJobExecutionListener(listener);
        }

        return bean;
    }

}