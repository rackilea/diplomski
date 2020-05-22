public class Test {

    static class User {
        @Pattern(regexp = "\\S+\\s+\\S+") // names delimited by one or more spaces
        String fullName;

        public User(String fullName) {
            this.fullName = fullName;
        }
    }

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        validator.validate(new User("Fname")).size(); // 1 validation error
        validator.validate(new User("Fname Lname")).size(); // 0 validation errors
    }
}