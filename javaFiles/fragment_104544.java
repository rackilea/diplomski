@SpringBootApplication
public class So44490189Application {

    public static void main(String[] args) {
        SpringApplication.run(So44490189Application.class, args);
    }

    public static class UserCreatedEvent {
        private final String email;

        public UserCreatedEvent(String email) {
            this.email = email;
        }
    }

    @Service
    public static class UserService {
        @EventListener
        public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
            System.out.println("Creating user " + userCreatedEvent.email);
        }
    }

    @Service
    public static class MemberService {
        @EventListener
        public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
            System.out.println("Creating member " + userCreatedEvent.email);
        }
    }

    @Service
    public static class OperationService {
        private final ApplicationEventPublisher eventPublisher;

        @Autowired
        public OperationService(ApplicationEventPublisher eventPublisher) {
            this.eventPublisher = eventPublisher;
        }

        public void createUser(String email) {
            eventPublisher.publishEvent(new UserCreatedEvent(email));
        }
    }

    @RestController
    public static class OperationController {
        private final OperationService operationService;

        @Autowired
        public OperationController(OperationService operationService) {
            this.operationService = operationService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createUser(String email) {
            operationService.createUser(email);
        }
    }
}