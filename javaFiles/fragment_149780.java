import java.util.Hashtable;

public class HashMetrics {


    public static double bucketUsagePercentage(Hashtable<?,?> a, double loadfactor) {
        int bucketSize = getBucketSize(a, loadfactor);
        int[] bucketFrequency = new int[bucketSize];
        for (Object k : a.keySet()) {
            bucketFrequency[k.hashCode() % bucketSize]++;
        }
        int counter = 0;
        for (int i : bucketFrequency) {
            if (i > 0) counter++;
        }
        return (double)counter / bucketSize;
    }

    //skip empty buckets (very similar to previous function, last line is only changed)
    public static double averageChainLength(Hashtable<?,?> a, double loadfactor) {
        int bucketSize = getBucketSize(a, loadfactor);
        int[] bucketFrequency = new int[bucketSize];
        for (Object k : a.keySet()) {
            bucketFrequency[k.hashCode() % bucketSize]++;
        }
        int counter = 0;
        for (int i : bucketFrequency) {
            if (i > 0) counter++;
        }

        return (double)a.size() / counter;
    }

    public static int log2(int number) {
        if(number == 0)
            return 0;
        return 31 - Integer.numberOfLeadingZeros(number);
    }

    public static int getBucketSize(Hashtable<?,?> a, double loadFactor) {
        int n = a.size();
        int bucketSize = 2 << log2(n);
        if (bucketSize * loadFactor <= n) {
            bucketSize <<= 1;
        }
        return bucketSize;
    }
}