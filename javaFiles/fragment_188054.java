public class ConditionalOnMissingProcessor implements BeanPostProcessor, Ordered, ApplicationContextAware
{
private static final Logger LOG = Logger.getLogger(ConditionalOnMissingProcessor .class);

private ApplicationContext applicationContext;

// Ordering to last in chain.
@Override
public int getOrder()
{
    return Ordered.LOWEST_PRECEDENCE;
}

@Override
public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException
{
    this.applicationContext = applicationContext;
}

/**
 * Process each bean and inject proxy objects in fields marked with: {@ConditionalOnMissingBean}
 */
@Override
public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException
{
    LOG.debug("Processing bean: " + beanName);
    final Class clazz = bean.getClass();
    ReflectionUtils.doWithFields(clazz, new ReflectionUtils.FieldCallback()
    {
        @Override
        public void doWith(final Field field)
        {
            try
            {
                if(field.isAnnotationPresent(ConditionalOnMissingBean.class))
                {
                    ReflectionUtils.makeAccessible(field);
                     final String beanFieldName = field.getName();
                    ...
                    // Find proper implementation in application context
                    // Or create a proxy.
                    // Inject proxy or impl into a bean
                    field.set(bean, <value>));

                }
            }
            catch(IllegalAccessException e)
            {
                LOG.error("Cannot set " + field.getName() + " in " + beanName, e);
            }
        }
    });

    return bean;
}