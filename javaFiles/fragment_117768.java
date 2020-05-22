Session mailSession = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                                    protected PasswordAuthentication 
                                          getPasswordAuthentication() {
                                        return new PasswordAuthentication
                                          ("prakash.d2222","**************");
                                    }
                                });