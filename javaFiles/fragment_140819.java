Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//      props.put("mail.smtp.host", "smtp.gmail.com");smtp.office365.com
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587"); //change this port