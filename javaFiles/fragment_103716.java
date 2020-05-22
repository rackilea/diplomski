@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (StringUtils.isEmpty(user.getCompany().getCompanyShortName())) {
            errors.reject("your.error.code");
        }
    }
}