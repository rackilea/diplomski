import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
...
  @Bean
  public GracefulShutdown gracefulShutdown() {
    return new GracefulShutdown();
  }

  @Bean
  public EmbeddedServletContainerFactory servletContainer(final GracefulShutdown gracefulShutdown) {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    factory.addConnectorCustomizers(gracefulShutdown);
    return factory;
  }
...