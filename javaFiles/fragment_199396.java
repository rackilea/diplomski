public class Foo {

    @Inject BeanManager beanManager;

    public void foo() {
        Set<Bean<?>> beans = beanManager.getBeans(Bar.class);
        Bean<?> bean = beanManager.resolve(beans);
        CreationalContext<?> creationalContext = beanManager.createCreationalContext(bean);
        Bar bar = (Bar) beanManager.getReference(bean, Bar.class, creationalContext);   
    }
}