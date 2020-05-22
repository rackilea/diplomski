import java.util.Arrays;

public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    PROJECT p = test.OpenProject(1,"???");

    System.out.println("PD1");
    PROJECTDETAILS pd1 = test.GetProjectDetails(p, 1);
    System.out.println(Arrays.toString(pd1.getItemList()));
    System.out.println(pd1.getProjectName());

    System.out.println("PD2");
    PROJECTDETAILS pd2 = test.GetProjectDetails(p, 2);
    System.out.println(Arrays.toString(pd2.getItemList()));
    System.out.println(pd2.getProjectName());
  }
}