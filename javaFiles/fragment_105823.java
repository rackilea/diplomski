import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<Object[]> list = new ArrayList<Object[]>();

    public void addList(Object... obj) {
        System.out.println("in object");
        list.add(obj);
    }

    public void addList(List<?> lst) {
        System.out.println("in List<?>");
        list.add(lst.toArray());
    }

    public static void main(String[] args) {
        Test testObj = new Test();
        List<String> myStrings = new ArrayList<String>();
        myStrings.add("string 1");
        myStrings.add("string 2");
        myStrings.add("string 3");

        // The variable argument method is called but this is a list!
        testObj.addList(myStrings);

    } 
}