Session session=Session.getDefaultInstance(new Properties());
MimeMessage mimeMsg= new MimeMessage(session);
String subject="Herr Müller reist nach \u0141\u00f3d\u017a.";
mimeMsg.setSubject(subject,"utf-8");
System.out.println(subject);
System.out.println(mimeMsg.getHeader("Subject")[0]);