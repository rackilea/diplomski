private static final Object LOCK = new Object();

   public void processMails(){
             List<String> mails;
             synchronize(LOCK){
                   mails  = getMails();
                   markMails(mails);
              }
              sendMails(mails);

          }