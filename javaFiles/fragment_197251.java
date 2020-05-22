public class BaseModel {

    private String type;
    private int count;

    public void setType(String type) {  this.type = type; }
    public String getType() {return type;}
    public int getCount() { return count;}
    public void setCount(int count) {this.count = count;}

    @Override
    public String toString() {return "BaseModel [type=" + type + ", count=" + count + "]";}

}