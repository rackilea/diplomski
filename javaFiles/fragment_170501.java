if(user != null) {
    Logger.warn("User account already created for email %s", email);
    validation.addError("email", "This email address already in use.");
    params.flash();
    flash.error("Please correct the error below!");
    validation.keep();
    signup();
}