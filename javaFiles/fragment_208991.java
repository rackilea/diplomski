Authenticator authenticator = new Authenticator() {

        public PasswordAuthentication getPasswordAuthentication() {
            return (new PasswordAuthentication("user",
                    "password".toCharArray()));
        }
    };
    Authenticator.setDefault(authenticator);