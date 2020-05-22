@RunWith(Parameterized.class)
public class CommentingTest{

     @Parameters
     public static Collection<Object[]> createData(){
                List<Object[]> data = new ArrayList<Object[]>();

                 for(Accounts account : Accounts.values()){
                    for(ViewMode view : ViewMode.values()){
                         data.put(new Object[]{account, view});
                    }
                  }
                 return data;
    }


    private Account account;
    private ViewMode mode;

    public CommentingTest(Account a, ViewMode v){
       this.account=a;
       this.viewMode = v;
    }

    //Put your tests here using the given account and view
    @Test
    public void foo(){

    }

    @Test
    public void bar(){

    }