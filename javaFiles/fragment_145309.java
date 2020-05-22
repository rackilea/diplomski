@Configuration
public class SomeConfig() {

@Bean(name = {SPRING_LIB_BEAN_NAME})
public static AnnotationTypeAnnotationBeanPostProcessor annotationTypeAnnotationBeanPostProcessor() {
    return new AnnotationTypePostProcessor();
}