//f(n, k, m) = sum (1 .. m) f(n - i, k - 1, m)

public class BarCode {
    public static Map<String, Integer>  memo    = new HashMap<>();

    public static int count(int units, int bars, int width) {
        int sum = 0;

        final String key = units + " " + bars;
        Integer memoSum = memo.get(key);
        if (memoSum != null) {
           return memoSum.intValue();
        }

        for (int i = 1; i <= width; ++i) {
            if (units == 0 && bars == 0)
                return 1;
            else if (bars == 0)
                return 0;
            else {
                sum += count(units - i, bars - 1, width);
            }
        }

        memo.put(key, Integer.valueOf(sum));

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int bars = in.nextInt();
        int width = in.nextInt();
        memo = new HashMap<>();
        int sum = 0;
        sum += count(num, bars, width);
        System.out.println(sum);
        in.close();
    }
}