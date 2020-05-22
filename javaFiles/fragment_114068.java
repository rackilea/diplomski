import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserFromHeaderConverter implements Converter<String, User> {

    @Override
    public User convert(final String userId) {
        // fetch user from the database etc.

        final User user = new User();
        user.setId(userId);
        user.setFirstName("First");
        user.setLastName("Last");

        return user;
    }
}