public class UserNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "User with given name is not found!";

    public UserNotFoundException() {
        this(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}