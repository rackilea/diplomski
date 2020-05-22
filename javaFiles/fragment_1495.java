public class PersonController extends SimpleFormController {

    public PersonController() {
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

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        return new ModelAndView();
    }

}