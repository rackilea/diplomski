@Autowired
private ConfigurableListableBeanFactory beanFactory;

@Bean
public BeanPostProcessor jmsTopicConnFactoryAliasCreator()
{
  return new BeanPostProcessor()
  {
     @Override
     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
     {
        if(bean instanceof TopicConnectionFactory)
        {
           beanFactory.registerAlias(beanName, "<LEGACY_BEAN_LOOKUP_NAME>");
        }
        return bean;
     }
  };
}