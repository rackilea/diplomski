class CollaboratorsFinder implements BeanFactoryPostProcessor {

    private final Object bean;
    private final Set<String> collaborators = new HashSet<String>();

    CollaboratorsFinder(Object bean) {
        if (bean == null) {
            throw new IllegalArgumentException("Must pass a non-null bean");
        }
        this.bean = bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        for (String beanName : BeanFactoryUtils.beanNamesIncludingAncestors(beanFactory)) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isAbstract()) {
                continue;   // assuming you're not interested in abstract beans
            }
            // if you know that your bean will only be injected via some setMyBean setter:
            MutablePropertyValues values = beanDefinition.getPropertyValues();
            PropertyValue myBeanValue = values.getPropertyValue("myBean");
            if (myBeanValue == null) {
                continue;
            }
            if (bean == myBeanValue.getValue()) {
                collaborators.add(beanName);
            }
            // if you're not sure the same property name will be used, you need to
            // iterate through the .getPropertyValues and look for the one you're
            // interested in.

            // you can also check the constructor arguments passed:
            ConstructorArgumentValues constructorArgs = beanDefinition.getConstructorArgumentValues();
            // ... check what has been passed here 

        }

    }

    public Set<String> getCollaborators() {
        return collaborators;
    }
}