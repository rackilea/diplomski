@Async
    public void sendTestingMail(String mail) {
      String subject = "Test mail from Project Management System";
      String content = "<h1>Be happy, Enjoy Life...!!!</h1>";
      sendMail(mail, subject, content, false, true);
    }