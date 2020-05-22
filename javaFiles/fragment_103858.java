public abstract class UUIDAggregate {
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected void publish(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }
    public List<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}

@Component
class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private DomainEventPublisher publisher;

    @Override
    public void updateUserAccount(UserAccount userAccount) {
        userAccount.update();

        userAccount.domainEvents().forEach(publisher::publishEvent);
    }
}