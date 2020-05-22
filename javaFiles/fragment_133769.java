import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StartStopJmsBatch {

private static final Logger LOG = LoggerFactory.getLogger(StartStopJmsBatch.class);

@Autowired
private DefaultMessageListenerContainer messageListenerContainer;

@Scheduled(cron = "0 0 * * * *")
public void startJmsConsumer() {
    if (!messageListenerContainer.isRunning()) {
        LOG.info("Started JmsListenerContainer");
        messageListenerContainer.start();
    }
}
}