public Authenticator getAuth(String user, String password) {
    new Authenticator() {
        public PasswordAuthentication getPasswordAuthentication() {
            return (new PasswordAuthentication(user, password.toCharArray()));
        }
    };
}