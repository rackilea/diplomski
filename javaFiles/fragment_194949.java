@Test
public void anotherLazyLoadTest() {
      //get a session object
      Session session = dao.getSession(); 

      //load object
      Foo foo = dao.findById(1);

      //if you have a detached object, this would be unnessary
      session.close();  

      boolean isInitialized = Hibernate.isInitialized(foo.getBars());
      assertFalse(isInitialized);
}