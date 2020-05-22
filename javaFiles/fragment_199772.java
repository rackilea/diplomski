// -- Create a new message --
final MimeMessage msg = new MimeMessage(session);

// -- Set the FROM and TO fields --
msg.setFrom(new InternetAddress(username));
msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

if (ccEmail.length() > 0) {
msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
}

msg.setSubject(title, "utf-8");
msg.setText(message, "utf-8");
msg.setHeader("Content-Type", "text/html; charset=UTF-8");
msg.setSentDate(new Date());

MimeBodyPart mbp1 = new MimeBodyPart();
  try {
mbp1.setDataHandler(new DataHandler(
new ByteArrayDataSource(message.toString(), "text/html")));
      } catch (IOException e1) {
     e1.printStackTrace();
  }
 mbp1.setHeader("Content-Type","text/plain; charset=\"utf-8\""); 
 mbp1.setContent( message, "text/html; charset=utf-8" ); 
 mbp1.setHeader("Content-Transfer-Encoding", "quoted-printable");

// create the second message part
MimeBodyPart mbp2 = new MimeBodyPart();

// attach the file to the message
try {
mbp2.attachFile(fileName);
    } catch (IOException e) {
   e.printStackTrace();
}

Multipart mp = new MimeMultipart();
mp.addBodyPart(mbp1);
mp.addBodyPart(mbp2);
msg.setContent(mp, "text/html");