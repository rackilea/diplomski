import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class Performance extends SimpleBenchmark
{
  final Random rnd = new Random();
  final String as1 = "aoeuaoeuaoeu", as2 = "snthsnthnsth", as3 = "3453409345";
  final char[] c1 = as1.toCharArray(), c2 = as2.toCharArray(), c3 = as3.toCharArray();

  public static char[] concat(char[] s1, char[] s2, char[] s3) {
    char buf[] = new char[s1.length + s2.length + s3.length];
    System.arraycopy(s1, 0, buf, 0, s1.length);
    System.arraycopy(s2, 0, buf, s1.length, s2.length);
    System.arraycopy(s3, 0, buf, s1.length + s2.length, s3.length);
    return buf;
  }

  public static String build(String s1, String s2, String s3) {
    final StringBuilder b = new StringBuilder(s1.length() + s2.length() + s3.length());
    b.append(s1).append(s2).append(s3);
    return b.toString();
  }

  public static String plus(String s1, String s2, String s3) {
    return s1 + s2 + s3;
  }

  public int timeConcat(int reps) {
    int tot = rnd.nextInt();
    for (int i = 0; i < reps; i++) tot += concat(c1, c2, c3).length;
    return tot;
  }

  public int timeBuild(int reps) {
    int tot = rnd.nextInt();
    for (int i = 0; i < reps; i++) tot += build(as1, as2, as3).length();
    return tot;
  }

  public int timePlus(int reps) {
    int tot = rnd.nextInt();
    for (int i = 0; i < reps; i++) tot += plus(as1, as2, as3).length();
    return tot;
  }

  public static void main(String... args) {
    Runner.main(Performance.class, args);
  }
}