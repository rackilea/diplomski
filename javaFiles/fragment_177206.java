@Slf4j
@Component
public class MyBusinessEventListener {

    @TransactionalEventListener(fallbackExecution = true)
    public void handleEvent(MyBusinessEvent myBusinessEvent) {
        log.info("[MyBusinessEventListener] New event received with following data: {}", myBusinessEvent);
    }
}