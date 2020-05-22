@RunWith(EasyMockRunner.class)
public class MyServiceImplTest {

    @org.easymock.Mock
    private MyServiceDao myServiceDao;

    @TestSubject
    private MyServiceImpl myServiceImpl = new MyServiceImpl();

    @Test
    public void testGetDatesMi() throws Exception {

        MarketLimits limits = new MarketLimits();
        limits.greaterThenOne(true);
        expect(myServiceDao.getDates(23)).andReturn(limits);
        replay(myServiceDao);

        myServiceImpl.getDatesMi();

        verify(myServiceDao);
    }
}

public class MarketLimits {
    private boolean b;

    public void greaterThenOne(boolean b) {
        this.b = b;
    }

    public boolean greaterThenOne() {
        return b;
    }
}

public interface MyServiceDao {
    MarketLimits getDates(long orgId);
}

public class MyServiceImpl {

    private MyServiceDao myServiceDao;


    public String getDatesMi() throws Exception {
        MarketLimits subDates = getDates(23);

        System.out.print(subDates);  // this prints out null

        if(subDates.greaterThenOne()){
            // do some things
        }

        return "result";
    }

    public MarketLimits getDates(long orgId) {
        return myServiceDao.getDates(orgId);
    }

    public void setMyServiceDao(MyServiceDao myServiceDao){
        this.myServiceDao = myServiceDao;
    }

}