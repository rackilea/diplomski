HtmlEmail email = new ImageHtmlEmail();
  email.setHostName("mail.myserver.com");
  email.addTo("jdoe@somewhere.org", "John Doe");
  email.setFrom("me@apache.org", "Me");
  email.setSubject("Test email with inline image");

  // embed the image and get the content id
  URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
  String cid = email.embed(url, "Apache logo");

  // set the html message
  email.setHtmlMsg(htmlEmailTemplate, new File("").toURI().toURL(), false);