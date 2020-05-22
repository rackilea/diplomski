public static boolean verifyLoginByUsernameAndPassword(ArrayList<User> user, String username, String password) {
    for(User s: user) {
        if(username.equals(s.getUserName()) && password.equals(s.getPassWord())) {
            return true;
        }
    }
    throw new IllegalArgumentException("Username and password are incorrect ");

}