public abstract class AbstractUseCase<T> implements UseCase<T> {

    protected final Class<T> type;

    protected AbstractUseCase(Class<T> type) {
        this.type = type;
    }

    @Override
    public User execute(Request request) {
        // create newUser based on request here
        return newUser;
    }
}

public class DefaultCreateUser extends AbstractUseCase<User> {

    public DefaultCreateUser() {
        super(User.class);
    }

    private Request request = new CreateUserRequest();

    @Override
    public User execute(Request request) {
        return new User();

        // Alternative in the base class:
        T newUser = type.getConstructor().newInstance();
        return newUser;

        // Alternative in the base class:
        Object newUser = ...;
        return type.cast(newUser);
    }
}