@RequestMapping(...)
public String createUser(@Valid CreateUserForm form, BindingResult result) {
    if (!form.getConfirmPassword().equals(form.getUser().getPassword())) {
        result.rejectValue("confirmPassword", ...);
    }
    ...
}