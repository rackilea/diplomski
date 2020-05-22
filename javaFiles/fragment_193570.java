public static Result loginApproach(){
    Form<User_Login> loginForm = form(User_Login.class).bindFromRequest();

    String formToString =
            loginForm.get().email + " with pass: " + loginForm.get().passwd;

    return ok(formToString);
}