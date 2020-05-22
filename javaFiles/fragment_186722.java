class MyBPP implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}

@Configuration
public class MyConfiguration {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBPP myBeanPostProcessor() {
        return new MyBPP();
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MyConfiguration.class);
    }
}