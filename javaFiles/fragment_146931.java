import java.util.Arrays;

public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    PROJECT p = test.OpenProject(1,"???");
    PROJECTDETAILS pd1 = new PROJECTDETAILS();
    test.GetProjectDetails(p, 1, pd1);
    System.out.println(Arrays.toString(pd1.getInfo().getItemList()));
  }
}