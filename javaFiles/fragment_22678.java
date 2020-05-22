public class Person  extends Model{

    public String getFirstName() {
       return getString("first_name");
    }

    public void setFirstName(String f) {
       set("first_name", f)
    }
}