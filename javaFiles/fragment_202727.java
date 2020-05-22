public static void addBook(String title, String authName, String publisher, String genre) { 

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = null;
// create book Object
Book book = new Book();
book.setTitle(title);
book.setAuthName(authName);
book.setPublisher(publisher);
book.setGenre(genre);

try {
 tx = session.beginTransaction();
 // Save the book to database
 session.save(book); 
 tx.commit();
 }catch(Exception e){
    if (tx!=null) {
     tx.rollback();}
  e.printStackTrace(); 
 }finally{
 // close your session
 session.close();
 }
}