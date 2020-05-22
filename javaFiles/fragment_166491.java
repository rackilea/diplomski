final String username = "user";
final String password = "pass";
Authenticator.setDefault(new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
                    username,
                    password.toCharArray());
            }
});