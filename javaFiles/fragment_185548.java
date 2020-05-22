public static void main(String[] args) throws Exception {
        Session sessionIMAP;
        sessionIMAP = setupImap();
        while(true) {

            Store store = sessionIMAP.getStore("imap");
            store.connect("localhost", 3143, "test1@localhost", "test1@localhost");
            if (store.isConnected()) {
                System.out.println("IMAP is connected");
                Folder folder = store.getFolder("INBOX");
                if (folder != null) {
                    folder.open(Folder.READ_ONLY);
                    //folder.getMessage(1);
                    if(folder.getMessageCount() > 0) {
                        System.out.println("maulik - " + folder.getMessage(1).getSubject());
                    }
                    Message[] messages = folder.getMessages();
                    System.out.println("maulik messages.length---" + folder.getMessageCount());
                }
            } else {
                System.out.println("IMAP is not connected");
            }
            Thread.sleep(1000);
        }
    }

    private static Session setupImap() {
        System.out.println("in setupImap");
        Session session1;
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imap");
        props.put("mail.imap.host", "localhost");
        props.put("mail.imap.port", 3143);
        props.put("mail.debug", "true");
        props.put("mail.imap.localaddress", "127.0.0.1");
        session1 = Session.getInstance(props, null);
        return session1;
    }