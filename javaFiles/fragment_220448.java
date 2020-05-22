import java.util.Random;

    public class TestOptimization {

        public static void main(String args[]) {
            Random rn = new Random();
            long l1 = 0, l2 = 0, l3 = 0;
            long nano1 = System.nanoTime();
            for (int i = 1; i < 10000000; i++) {
                int num = rn.nextInt(100);
                l1 += sum(num);
            }
            long nano2 = System.nanoTime();
            for (int i = 1; i < 10000000; i++) {
                int num = rn.nextInt(100);
                l2 += mult(num);
            }
            long nano3 = System.nanoTime();
            for (int i = 1; i < 10000000; i++) {
                int num = rn.nextInt(100);
                l3 += shift(num);
            }
            long nano4 = System.nanoTime();
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(l3);
            System.out.println("sum   : " + (nano2 - nano1));
            System.out.println("mult  : " + (nano3 - nano2));
            System.out.println("shift : " + (nano4 - nano3));
        }

        private static long sum(long x) {
            return x + x + x;
        }

        private static long mult(long x) {
            return 3 * x;
        }

        private static long shift(long x) {
            return (x << 2) - x;
        }

    }