@Test(expected=LazyInitializationException.class)
public void lazyLoadTest() {
  //get a session object
  Session session = dao.getSession(); 

  //load object
  Foo foo = dao.findById(1);

  //if you have a detached object, this would be unnessary
  session.close();  

  //if lazy loading is working, an exception will be thrown
  //note: If you don't try to access the collection (.size(), the data will not be fetched)
  foo.getBars().size(); 
}