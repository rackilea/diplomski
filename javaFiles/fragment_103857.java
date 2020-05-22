@Component
class UserAccountFactoryImpl implements UserAccountFactory {
    @Autowired
    private DomainEventPublisher publisher;

    @Override
    public UserAccount newUserAccount(String email, String username, ...) {
        return new UserAccount(email, username, ..., publisher);
    }
}