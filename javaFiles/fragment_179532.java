import java.util.ArrayList;
import java.util.List;

public class Test {

  String name;
  List<Test> related;

  public Test(int numberToAdd) {

    name = "dog";
    related = new ArrayList<Test>();
    for (int i = 0; i < numberToAdd; i++) {
      related.add(new Test(0));
    }
  }

  public List<Test> relate() {

    return related;
  }

  public String toString() {
    return name;
  }

  public static void main(String[] args) {

    Test test = new Test(3);
    for (Test t : test.relate()) {
      System.out.println(t);
    }
  }
}