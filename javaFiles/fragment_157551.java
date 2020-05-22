import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.catalina.connector.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

  private static final Logger log = LoggerFactory.getLogger(GracefulShutdown.class);
  private volatile Connector connector;

  @Override
  public void customize(Connector connector) {
    this.connector = connector;
  }

  @Override
  public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
    log.info("Protocol handler is shutting down");

    this.connector.pause();
    Executor executor = this.connector.getProtocolHandler().getExecutor();
    if (executor instanceof ThreadPoolExecutor) {
      try {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        threadPoolExecutor.shutdown();

        if (!threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS))
          log.warn("Tomcat thread pool did not shut down gracefully within 30 seconds. Proceeding with forceful shutdown");
        else
          log.info("Protocol handler shut down");

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}