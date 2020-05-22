public class Main {
    public static void main(String[] args) {
        evenOdd(new int[]{1, 2, 3, 4, 5, 6, 7});
        evenOdd(new int[]{2, 3, 4, 5, 6, 7});
        evenOdd(new int[]{1, 1, 1, 1, 1});
        evenOdd(new int[]{2, 2, 2, 2});
    }

    public static void evenOdd(int[] a) {
        int firstOdd = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] % 2 == 0) {
                int t = a[firstOdd];
                a[firstOdd] = a[i];
                a[i] = t;
                firstOdd++;
//            } else {
//                else is redundant, just leave odd in-place
            }
        }
        System.out.println(Arrays.toString(a));
    }
}