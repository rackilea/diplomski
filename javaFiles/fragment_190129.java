Properties props = new Properties();
InitialContext ictx = new InitialContext(props);
Session sess = (Session) ictx.lookup("java:jboss/mail/Default");
props = sess.getProperties();
props.put("mail.smtp.host", "xxx.tld");
props.put("mail.host", "xxx.tld");
props.put("mail.from", "yyy@xxx.tld");
sess = Session.getInstance(props);