properties.setProperty("mail.store.protocol", "pop3s");
properties.setProperty("mail.pop3s.host", popHost);
properties.setProperty("mail.pop3s.port", String.valueOf(openPort));
properties.setProperty("mail.pop3s.auth", "true");
properties.setProperty("mail.pop3s.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory" ); 
properties.setProperty("mail.pop3s.ssl.trust", "*");

store = session.getStore( "pop3s" );