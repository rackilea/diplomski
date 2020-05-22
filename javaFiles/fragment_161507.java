@Bean
public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.setTomcatContextCustomizers(Arrays.asList(new CustomCustomizer()));
    return factory;
}

static class CustomCustomizer implements TomcatContextCustomizer {
    @Override
    public void customize(Context context) {
        context.setUseHttpOnly(false);
    }
}