import java.util.Arrays;

public class Test {
    static int N = 10000;
    public static void main(String [] args) throws Exception {
        if(args.length > 0) {
            N = Integer.parseInt(args[0]);
        }
        String [] array = new String[100000];
        for(int i = 0; i < array.length; i++) {
            array[i] = "abcdef" + i;
        }
        long start = System.currentTimeMillis();
        fancy(array);
        System.err.println("Fancy took " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();
        oldSchool(array);
        System.err.println("Loop took " + (System.currentTimeMillis() - start) + "ms");

    }

    public static void fancy(String [] array) {
        for(int i = 0; i < N; i++) {
            String [] full_suffixes = Arrays.stream(array)
                                          .map(suffix -> "re" + suffix)
                                          .toArray(size -> new String[size]);
        }
    }

    public static void oldSchool(String [] array) {
        for(int i = 0; i < N; i++) {
            String [] full_suffixes = new String[array.length];
            for(int j = 0; j < array.length; j++) {
                    full_suffixes[j] = "re" + array[j];
            }
        }
    }
}