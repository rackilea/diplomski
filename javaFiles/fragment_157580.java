public String register(@Valid @ModelAttribute User user, BindingResult result, @RequestParam("confirmEmail", required=false) String confirmEmail) {
     if (!StringUtils.equals(confirmEmail, user.getEmail()) {
         result.reject("email", "email.confirm.mustequal");
     }
    ....

}