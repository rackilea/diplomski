public class Configurer implements BeanPostProcessor {
    public void postProcessAfterInitialization(String name, Object bean) {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            AnnotationMethodHandlerAdapter a = (AnnotationMethodHandlerAdapter) bean;
            HttpMessageConverter[] convs = a.getMessageConverters();
            ... add new converter ...
            a.setMessageConverters(convs);
        }
    }
    ...
}