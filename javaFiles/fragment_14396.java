import java.util.Arrays;
public class b {
  public static void main(String[] args) {
    String[] processes = { "256,6", "400,8", "128,4" };
    String[] a1 = new String[processes.length];
    String[] a2 = new String[processes.length];
    for (int i = 0; i < processes.length; i++) {
      String[] pieces = processes[i].split(",");
      a1[i] = pieces[0];
      a2[i] = pieces[1];
    }
    System.out.println(Arrays.toString(a1));
    System.out.println(Arrays.toString(a2));
  }
}