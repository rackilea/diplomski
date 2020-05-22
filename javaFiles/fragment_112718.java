Mailer mailer = new Mailer(// note: from 5.0.0 on use MailerBuilder instead
        new ServerConfig("localhost", thePort, theUser, thePasswordd),
        TransportStrategy.SMTP_PLAIN,
        new ProxyConfig(proxyHost, proxyPort /*, proxyUser, proxyPassword */)
);

mailer.sendMail(new EmailBuilder()
        .from("mytest", "mytest@test.com")
        .to("test", "test@test.com")
        .subject("This is the subject line")
        .textHTML("<h1>This is the actual message</h1>")
        .build());

System.out.println("Message sent...");