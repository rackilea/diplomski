public class EncodingPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name)
            throws BeansException {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            HttpMessageConverter<?>[] convs = ((AnnotationMethodHandlerAdapter) bean).getMessageConverters();
            for (HttpMessageConverter<?> conv: convs) {
                if (conv instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) conv).setSupportedMediaTypes(
                        Arrays.asList(new MediaType("text", "html", 
                            Charset.forName("UTF-8"))));
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String name)
            throws BeansException {
        return bean;
    }
}