public void processMails(){
     List<String> mails;
     synchronized(this){
           mails  = getMails();
           markMails(mails);
      }
      sendMails(mails);

  }