@Override
public boolean isValid(String userName, ConstraintValidatorContext context) {
    if (userService.findByUserName(userName) != null) {
        context.disableDefaultConstraintViolation();
        context
            .buildConstraintViolationWithTemplate("User " + userName + "already exists!")
            .addConstraintViolation();
        return false;
    }
    return true;
}