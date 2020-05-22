package personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpeedTest {

  public static void main(String[] args) {
    int loops = 10;
    double DELAY = 1000;
    int i;
    double[] loopCount = new double[loops + 1];
    double sum = 0;
    for (i = 0; i < loops + 1; i++) {

      long startTime = System.currentTimeMillis();
      long endTime = (long)(startTime + DELAY);
      long index = 0;

      while (true) {
        fizzString("TEST");
        //fizzString2("TEST");
        long now = System.currentTimeMillis();
        if (now >= endTime) {
          break;
        }
        index++;
      }

      if (i != 0) {
        if (DELAY != 1000) {
          if (DELAY / 1000 % 1 == 0) {
            System.out.printf("Test %.0f. %,.0f loops in %.0f seconds.\n", (float) i, (float) index, (float) DELAY / 1000);
          } else if ((DELAY / 100) % 1 == 0) {
            System.out.printf("Test %.0f. %,.0f loops in %.1f seconds.\n", (float) i, (float) index, (float) DELAY / 1000);
          } else if ((DELAY / 10) % 1 == 0) {
            System.out.printf("Test %.0f. %,.0f loops in %.2f seconds.\n", (float) i, (float) index, (float) DELAY / 1000);
          } else if (DELAY % 1 == 0) {
            System.out.printf("Test %.0f. %,.0f loops in %.3f seconds.\n", (float) i, (float) index, (float) DELAY / 1000);
          }
        } else {
          System.out.printf("Test %.0f. %,.0f loops in %.0f second.\n", (float) i, (float) index, (float) DELAY / 1000);
        }
        loopCount[i] = index;
      }
    }
    Arrays.sort(loopCount);
    System.out.printf("Least loops: %,.0f\n", (loopCount[1]));
    System.out.printf("Most loops: %,.0f\n", loopCount[loops]);

    for (int d = 1; d < loopCount.length; d++) {
      sum += loopCount[d];
    }
    double averageLoopCount = 1.0f * sum / (loopCount.length - 1);
    System.out.printf("Average loops: %,.1f", averageLoopCount);
  }

  public static String fizzString(String str) {
    if (str.startsWith("f") && str.endsWith("b")) return "FizzBuzz";
    if (str.startsWith("f")) return "Fizz";
    if (str.endsWith("b")) return "Buzz";

    return str;
  }

  public static String fizzString2(String str) {
    String sum = "";

    if (str.startsWith("f")) sum += "Fizz";
    if (str.endsWith("b")) sum += "Buzz";

    return (sum == "") ? str : sum;
  }
}