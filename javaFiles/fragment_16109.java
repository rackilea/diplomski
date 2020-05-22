@Component
@Slf4j
public class DeadLetterQueueListener {

    @PostConstruct
    public void logReferenceId(){
        log.debug("just built deadLetterQueueListener : "+this);
    }

    ...
}