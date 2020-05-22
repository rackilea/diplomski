Properties prop = System.getProperties();

    String host = "imap.gmail.com";
    String username = "user@google.com";
    String password = "some-password";

    prop.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    prop.setProperty("mail.imap.host", host);
    prop.setProperty("mail.imap.port", "993");
    prop.setProperty("mail.imap.starttls.enable", "true");
    prop.setProperty("mail.imap.socketFactory.fallback", "false");
    prop.setProperty("mail.debug", "true");

    Session ses = Session.getInstance(prop, null);
    Store store = ses.getStore("imap");
    store.connect(host, username, password);

    if (!IMAPStore.class.isInstance(store))
        throw new IllegalStateException("Is not IMAPStore");

    IMAPStore imapStore = (IMAPStore) store;
    Quota[] quotas = imapStore.getQuota("INBOX");

    for (Quota quota : quotas) {
        System.out.println(String.format("quotaRoot:'%s'", quota.quotaRoot));

        for (Quota.Resource resource : quota.resources) {
            System.out.println(String.format("name:'%s', limit:'%s', usage:'%s'",
                    resource.name, resource.limit, resource.usage));
        }
    }