public class YourListData {

    private long id;
    private String desc;

    public YourListData(){
    }


    public void setDesc(String desc){ this.desc = desc; }
    public void setListId(long name){ this.id = id; }

    public String getDesc(){ return this.desc; }
    public long getListId(){ return this.id; }
}