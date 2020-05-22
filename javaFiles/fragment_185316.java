public class UserValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
      return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
      User user = (User) target;

      if(user.getName() == null) {
          errors.rejectValue("name", "your_error_code");
      }

      // do "complex" validation here

    }

}