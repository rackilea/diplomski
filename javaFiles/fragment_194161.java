Properties props = System.getProperties();
    props.setProperty("mail.store.protocol", "imaps");

    Session session = Session.getInstance(props, null);
    session.setDebug(true);
    Store store = session.getStore("imaps");

    MailSSLSocketFactory socketFactory = new MailSSLSocketFactory();
    socketFactory.setTrustAllHosts(true);

    props.put("mail.imaps.ssl.socketFactory", socketFactory);
    System.out.println("store is "+store.isConnected());

    store.connect("mail.abc.com","xyz@abc.com", "******");
    System.out.println("Now the store  is  "+store.isConnected());