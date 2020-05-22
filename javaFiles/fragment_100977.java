import java.util.ArrayList;
import java.util.Collections;

public class TestArray {

  public static void main(String[] arg) {
    ArrayList<Object> list = new ArrayList<Object>(Collections.nCopies(5, null));
    System.out.println(list);
  }
}