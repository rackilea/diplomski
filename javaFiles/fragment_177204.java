@Transactional
@Service
public class MyBusinessService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public MyBusinessService(
            ApplicationEventPublisher applicationEventPublisher) {

        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void save() {
        String data = "Testing event data";
        MyBusinessEvent event = new MyBusinessEvent(data);
        applicationEventPublisher.publishEvent(event);
    }
 }