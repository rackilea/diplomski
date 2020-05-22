public class ApplicationUserFormValidator implements Validator {
    public void validate(Object target, Errors errors) {
        ApplicationUserForm f = (ApplicationUserForm) target;

        if (!f.getConfirmPassword().equals(f.getUser().getPassword())) ...

        errors.pushNestedPath("user");
        new ApplicationUserValidator().validate(f.getUser(), errors);
        errors.popNestedPath();
    }
    ...
}