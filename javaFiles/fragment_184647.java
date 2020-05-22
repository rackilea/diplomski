@Component
public class AnimalFactory implements BeanFactoryAware {

    private BeanFactory factory;

    public Animal create(String input) {
        if ("cat".equals(input) ) {
            return factory.getBean(Cat.class);

        } else if ("dog".equals(input) ) {
            return factory.getBean(Dog.class);
        }
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.factory=beanFactory;
    }

}