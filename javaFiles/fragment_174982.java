public class NameGenerator implements BeanNameGenerator{

@Override
public String generateBeanName(BeanDefinition definition,
        BeanDefinitionRegistry registry) {
    if(definition.getBeanClassName().contains("Toto")) {
        return "toto";
    }
    return return definition.getBeanClassName();
    }
}