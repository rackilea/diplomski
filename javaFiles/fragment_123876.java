import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSum {

    //run with -Xmx1g
    public static void main(String... args) {

        for (int sampleSize = 1; sampleSize < 1000; sampleSize*=5) {
            for (int size = 10; size <= 40_000_000; size *= 10) {
                System.gc();
                int[] numbers = new int[size];

                int a = 0;
                int aa = 1;
                for (int i = 0; i < size; i++) {
                    numbers[i] = a;
                    a += aa++;
                }

                Random r = new Random(42);
                int[] t = new int[sampleSize];
                for (int i = 0; i < sampleSize; i++) {
                    t[i++] = numbers[r.nextInt(size)] + numbers[r.nextInt(size)];
                }
                long b = System.currentTimeMillis();
                for (int i = 0; i < sampleSize; i++) {
                    twoSumMap(numbers, t[i]);
                }
                long c = System.currentTimeMillis();
                for (int i = 0; i < sampleSize; i++) {
                    twoSumArray(numbers, t[i]);
                }
                long d = System.currentTimeMillis();

                System.out.println(
                    "On size: " + size + " MAP takes: " + (c - b) + " ARRAY takes: " + (d - c) + " with sample size: " + sampleSize);
            }
        }
    }

    public static int[] twoSumMap(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static int[] twoSumArray(int[] nums, int target) {
        int[] sorted_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted_nums[i] = nums[i];
        }
        Arrays.sort(sorted_nums);

        int begin = 0;
        int end = sorted_nums.length - 1;
        while (begin < end) {
            if (sorted_nums[begin] + sorted_nums[end] == target)
                break;
            else if (sorted_nums[begin] + sorted_nums[end] > target)
                end--;
            else
                begin++;
        }

        int[] result = new int[2];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sorted_nums[begin] || nums[i] == sorted_nums[end])
                result[idx++] = i;
        }
        return result;
    }
}