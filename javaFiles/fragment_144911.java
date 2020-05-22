import java.util.HashSet;
import java.util.Set;

public class TimeComputationTest {

  public static void main(String[] args) {
    String strIds = null;
    Set<String> setOfids = new HashSet<String>();
    StringBuffer sb = new StringBuffer();

    for (int i = 1;i <= 1000;i++) {
      setOfids.add(String.valueOf(i));
      if (sb.length() != 0) {
        sb.append(",");
      }
      sb.append(i);
    }
    strIds = sb.toString();

    testTime(strIds, setOfids, "1");
    testTime(strIds, setOfids, "100");
    testTime(strIds, setOfids, "500");
    testTime(strIds, setOfids, "1000");
  }

  private static void testTime(String strIds, Set<String> setOfids, String string) {
    long startTime = System.nanoTime();
    strIds.indexOf(string);
    long endTime = System.nanoTime();

    System.out.println("String search time for (" + string + ") is " + (endTime - startTime));

    startTime = System.nanoTime();
    setOfids.contains(string);
    endTime = System.nanoTime();

    System.out.println("HashSet search time for (" + string + ") is " + (endTime - startTime));
  }
}