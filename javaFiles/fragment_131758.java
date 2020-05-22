SearchTerm messageIDTerm= new SearchTerm() {
     @Override
     public boolean match(Message message) {
     try {
          if (((MimeMessage) message).getMessageID().contains(sMessageId)) {
                   return true;
          }
         } catch (MessagingException ex) {
                    ex.printStackTrace();
         }
          return false;
      }
 };
msgs = folder.search(messageIDTerm);