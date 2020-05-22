public static void main(String []a)
{
   try{
    Session sess = HibernateUtils.getSessionFactory().openSession();
    sess.beginTransaction();
    MessageDetails messageDetails = new MessageDetails();
    messageDetails.setTo(new HashSet<EmailAndName>());
    EmailAndName emailAndName = (EmailAndName) sess.get(EmailAndName.class, 1L);
    if (emailAndName == null ) throw new RuntimeException();
    messageDetails.getTo().add(emailAndName);
    sess.save(messageDetails);
    sess.getTransaction().commit();
 }
catch(HibernateException e)
 {
   sess.getTransaction.rollback();
   e.printStackTrace();
 }
  finally{
       sess.close();
  }