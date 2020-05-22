public class PluginQualifierProcessor implements BeanFactoryPostProcessor {

private static final Logger LOGGER = LoggerFactory.getLogger(PluginQualifierProcessor.class);

@Override
public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    String[] beanNamesForType = beanFactory.getBeanNamesForType(PluginInterface.class);
    List<String> beans = Arrays.asList(beanNamesForType)
                               .stream()
                               .collect(Collectors.toList());

    for (String beanName : beans) {
        BeanDefinition bean = beanFactory.getBeanDefinition(beanName);
        if (!bean.hasConstructorArgumentValues()) {
            String className = bean.getBeanClassName();
            try {
                tryToInstatiate(className);
                // we are interested only in runtime linkage errors that can happen if plugin is erroneous
            } catch (LinkageError e) {
                LOGGER.error("plugin {} is erroneous. It will be discarded from context. {}", className, e);
                ((BeanDefinitionRegistry) beanFactory).removeBeanDefinition(beanName);
            }
        }
    }
}

private void tryToInstatiate(String className) {
    try {
        Class<?> beanClass = Class.forName(className);
        beanClass.newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        LOGGER.debug("skip exception while creating instance of {}. {}", className, e.getMessage());
    }
}