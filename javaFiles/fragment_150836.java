public class TestMyService extends EasyMockSupport {
   private MyService service;
   private MyDao dao;

   private MyObject myObj;

   @Before public void setUp() {
      service = new MyService();

      // THIS IS THE KEY
      mock = createMock(IDao.class); //CORRECT
      // mock = EasyMock.createMock(IDao.class); //WRONG

      service.setDao(mock);
      myObj = new MyObject("expectedData");
   }
   @After public void tearDown() {
      verifyAll();
   }
   @Test public void testMyService() {
      expect(mock.update(myObj)).andReturn(myObj);
      replayAll();
      service.myService(myObj);
   }
}

public class MyService() {
   private IDao dao;
   public void setDao(IDao dao) {this.dao = dao; }
   public MyObject myService(MyObject myObj) {
      return dao.update(myObj);
   }
}