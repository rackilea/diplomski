Properties props = new Properties();
props.put("mail.imap.ssl.enable", "true"); // required for Gmail
props.put("mail.imap.auth.mechanisms", "XOAUTH2");
Session session = Session.getInstance(props);
Store store = session.getStore("imap");
store.connect("imap.gmail.com", username, oauth2_access_token);