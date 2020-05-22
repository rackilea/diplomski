Connection conn = null;
        PreparedStatement pstmt = null;
        conn = getConnection();
        java.util.Date date = new Date();

        message.setFrom(new InternetAddress("test@gmail.com"));
        String query = "update Emails set SentOn = ? where Id = ? ";
        pstmt = conn.prepareStatement(query); // create a statement

        String str[]=String.valueOf(s.getRecordId()).split(";");//id1;id;id3;.... 
        for(int i=0;i<str.length();i++)
        {
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(s.getEmailTo().replace(";", ",")[i]));
        message.setSubject(s.getEmailSubject());
        message.setText(s.getEmailBody());
        message.setContent(s.getEmailBody(),"text/html");
        Transport.send(message);
        System.out.println("Done");

        pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
        pstmt.setInt(2, str[i]); // In this line I want to use my array-list to update my table.
        pstmt.executeUpdate(); // execute update statement
        System.out.println(str[i]+" "+s.getEmailTo().replace(";", ",")[i]+" "+new java.sql.Timestamp(date.getTime()));//to check whether its working or not.
      }