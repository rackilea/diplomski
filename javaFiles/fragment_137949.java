import java.util.*;
import java.lang.management.*;

public final class IntegersInBitSetMemoryConsumption {
  private final static int MILLION = 1000 * 1000;

  public static void main(String... args) {
    BitSet set = new BitSet(Integer.MAX_VALUE);

    for (int i = 1;; ++i) {
      if ((i % MILLION) == 0) {
        int milsOfEntries = (i / MILLION);
        long mbytes = ManagementFactory.getMemoryMXBean().
            getHeapMemoryUsage().getUsed() / MILLION;
        double ratio = mbytes / milsOfEntries;
        System.out.println(milsOfEntries + " mil, " + mbytes + " MiB used, "
            + " ratio of bytes per entry: " + ratio);
      }

      set.set(i);
    }
  }
}