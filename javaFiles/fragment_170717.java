public void sendEmail(TestSendEmails s) throws Exception{
    init();
    Message message = new MimeMessage(session);
    Connection conn = null;
    PreparedStatement pstmt = null;
    conn = getConnection();
    java.util.Date date = new Date();

    message.setFrom(new InternetAddress("test@gmail.com"));

    String query = "update Email set SentOn = ? where RecordId = ? ";
    pstmt = conn.prepareStatement(query); // create a statement

    String str[]=String.valueOf(s.getRecordId()).split(";");//RecordId1;RecordId;RecordId3;....

    for(int i=0;i<str.length;i++){
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(s.getEmailTo().replace(";", ",")));
        message.setSubject(s.getEmailSubject());
        message.setText(s.getEmailBody());

        message.setContent(s.getEmailBody(),"text/html");
        Transport.send(message);
        System.out.println("Email sent.");

        pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));

        pstmt.setString(2, str[i]);

        pstmt.addBatch(); // Add to batch
    }

    pstmt.executeBatch(); // Execute batch
}