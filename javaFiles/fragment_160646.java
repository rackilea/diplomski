public void create(@Valid User user) {
    Errors errors = new BeanPropertyBindingResult(user, "user");

    // Validator component has been previously injected into the service.
    uniqueUsernameValidator.validate(user, errors); 
    if (errors.hasErrors()) {
        throw new RuntimeException(errors.toString());
    }

    userRepository.save(user);
}