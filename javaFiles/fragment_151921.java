@Test
public void test1() throws MessagingException, IOException {
    Properties props = new Properties();
    props.put("mail.host", "localhost"); //Or use IP.
    Session s = Session.getInstance(props);
    MimeMessage m = new MimeMessage(s);
    m.setContent("<b>Hello</b>", "text/html; charset=utf-8");
    m.saveChanges();
    assertEquals(m.getContent(), "<b>Hello</b>");
    assertEquals(m.getContentType(), "text/html; charset=utf-8");
}