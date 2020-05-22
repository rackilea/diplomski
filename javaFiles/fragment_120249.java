import java.util.ArrayList;
import java.util.Date;

public class Test3 {

    private Number number;
    private String string;
    private Boolean bool; // Replace Boolean with Object, and it compiles!
    private Date date;
    private ArrayList<String> list; // Replace ArrayList with List, and it
                                    // compiles!

    public Object getValue() {
        return number != null ? number :
               string != null ? string :
               bool != null ? bool :
               date != null ? date :
               list != null ? list :
               null;
    }
}