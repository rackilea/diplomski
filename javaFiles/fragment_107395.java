public static Result profile(String userId) {
    Form<User> userForm = form(User.class);

    User user = User.findById(userId); // data have been set in the database
    if (user != null) {
         userForm = userForm.fill(user);
    }

    return redirect(your.view.render(userForm));
}