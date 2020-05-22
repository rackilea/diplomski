public class MyListData {

    // Add more as you need
    private long userId;
    private String firstName;

    public MyListData(){
    }


    public void setFirstName(String name){ this.firstName = name; }
    public void setUserId(long id){ this.userId = id; }

    public String getFirstName(){ return this.firstName; }
    public long getUserId(){ return this.userId; }
}