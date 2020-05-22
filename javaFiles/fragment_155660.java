public class CustomScope implements Scope, BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String name = "myScope";

        beanFactory.registerScope(name, this);

        Assert.state(beanFactory instanceof BeanDefinitionRegistry,
                "BeanFactory was not a BeanDefinitionRegistry, so CustomScope cannot be used.");
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;

        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
            if (name.equals(definition.getScope())) {
                BeanDefinitionHolder proxyHolder = ScopedProxyUtils.createScopedProxy(new BeanDefinitionHolder(definition, beanName), registry, false);
                registry.registerBeanDefinition(beanName, proxyHolder.getBeanDefinition());
            }
        }
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return objectFactory.getObject(); // a new one every time
    }

    @Override
    public String getConversationId() {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public Object resolveContextualObject(String arg0) {
        return null;
    }

}


public class Foo implements MessageListener {

    private Bar bar;

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println(bar.getId());
    }

}
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FooTests {

    @Autowired
    private Foo foo;

    @Test
    public void test() {
        Message message = mock(Message.class);
        foo.onMessage(message);
        foo.onMessage(message);
    }

}