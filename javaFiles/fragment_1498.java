public class PersonController extends SimpleFormController {

    public PersonController() {
        setMessageCodesResolver(new MyCustomMessageCodesResolver());
        setCommandClass(Person.class);
        setValidator(new Validator() {
            public boolean supports(Class clazz) {
                return clazz.isAssignableFrom(Person.class);
            }

            public void validate(Object command, Errors errors) {
                rejectIfEmpty(errors, "age", "Age is required");
            }
        });
    }