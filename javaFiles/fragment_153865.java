public static class Login {

    public String email;
    public String password;
    public User user;

    public String validate() {
        user = User.authenticate(email, password);
        if(user == null) {
            return "Invalid user or password";
        }
        return null;
    }
}