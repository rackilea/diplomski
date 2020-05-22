import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static final int COUNT = 1000000;
    static int[] ints = new int[COUNT];
    static Integer[] integers = new Integer[COUNT];

    static void primitiveToObject() {
        List<Integer> objects = new ArrayList<Integer>(ints.length);
        for (int i = 0; i < ints.length; i++) {
            int value = ints[i] + 1;
            objects.add(value);                    //boxing
        }
    }

    static void objectsToPrimitiveToObject() {
        List<Integer> result= new ArrayList<Integer>(integers.length);
        for (int i = 0; i < integers.length; i++) {
            int value = integers[i] + 1;           //unboxing
            result.add(value);                     //boxing
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < COUNT; ++i) {
            int val = rand.nextInt();
            ints[i] = val;
            integers[i] = val;
        }
        for (int i = 0; i < 10; ++i) {
            long start_p = System.currentTimeMillis();
            for (int j = 0; j < 100; ++j) {
                primitiveToObject();
            }
            long end_p = System.currentTimeMillis();
            long start_o = System.currentTimeMillis();
            for (int j = 0; j < 100; ++j) {
                objectsToPrimitiveToObject();
            }
            long end_o = System.currentTimeMillis();
            System.out.printf("p2o:%d o2p2o:%d\n", end_p - start_p, end_o - start_o);
        }
    }
}