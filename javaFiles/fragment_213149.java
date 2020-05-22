List<NamedFactory<UserAuth>> userAuthFactories = new ArrayList<NamedFactory<UserAuth>>();
userAuthFactories.add(new UserAuthPassword.Factory());
sshd.setUserAuthFactories(userAuthFactories);

sshd.setPasswordAuthenticator(new PasswordAuthenticator() {
    public boolean authenticate(String username, String password, ServerSession session) {
        return "tomek".equals(username) && "123".equals(password);
    }
});