sf.setTrustAllHosts(true);
    props.setProperty("mail.imaps.host", "imap.gmail.com");
    props.setProperty("mail.imaps.user", gmailUsername);
    props.setProperty("mail.imaps.password", password);
    props.setProperty("mail.imaps.port", "993");
    props.setProperty("mail.imaps.auth", "true");
    props.setProperty("mail.debug", "true");