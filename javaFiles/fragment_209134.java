@Component
public class TransactionInterceptorReplacer implements BeanFactoryPostProcessor {

@Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory factory) throws BeansException {
        String[] names = factory.getBeanNamesForType(TransactionInterceptor.class);
        for (String name : names) {
            BeanDefinition bd = factory.getBeanDefinition(name);
            bd.setBeanClassName(MyTransactionInterceptor.class.getName());
            bd.setFactoryBeanName(null);
            bd.setFactoryMethodName(null);
       }
   }
}