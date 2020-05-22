private void sendMail(String msg){
        try{            
            Email email = new Email();          
            email.setSendTo("yourname@acme.org");
            email.setSubject("Mail from Java");         
            email.setSenderEmail("no-rely@acme.org");           
            email.setSenderName("No-reply");            
            email.setBodyHTML(msg);             
            email.setBannerHTML("<p>Hi " + email.getSendTo() + ",</p>");            
            email.setFooterHTML("<p><b>Kind regards,</b><br/>" + email.getSenderName() + "<br/>0044 1234 5678</p>");
            email.send();           
        } catch (Exception e) {
            OpenLogUtil.logError(e);
        }
    }