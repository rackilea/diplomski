import java.util.ArrayList;
import java.util.List;

public class RemoveNullValue {
  public static void main( String args[] ) {
    String[] firstArray = {"test1", "", "test2", "test4", "", null};

    List<String> list = new ArrayList<String>();

    for(String s : firstArray) {
       if(s != null && s.length() > 0) {
          list.add(s);
       }
    }

    firstArray = list.toArray(new String[list.size()]);
  }
}