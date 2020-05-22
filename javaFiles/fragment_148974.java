@Autowired
AutowireCapableBeanFactory beanFactory;

public MyObjectThatShouldBePrototype getBean() {
    MyObjectThatShouldBePrototype bean = new MyObjectThatShouldBePrototype();
    beanFactory.autowireBean(bean);
    return bean;
}