public void processMails(){
         List<String> mails;
         synchronize(DAO.class){
               mails  = getMails();
               markMails(mails);
          }
          sendMails(mails);

      }