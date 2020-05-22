public class EncodingPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name)
            throws BeansException {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            HttpMessageConverter<?>[] convs = ((AnnotationMethodHandlerAdapter) bean).getMessageConverters();
            for (HttpMessageConverter<?> conv: convs) {
                if (conv instanceof StringHttpMessageConverter) {
                    ((StringHttpMessageConverter) conv).setSupportedMediaTypes(
                        Arrays.asList(new MediaType("text", "plain", 
                            Charset.forName("UTF-8"))));
                }
            }
        }
        return bean;
    }