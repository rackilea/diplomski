import java.util.*;

public class CircSubArray {
    static <T> Iterator<T[]> circularIterator(final T[] arr, final int K) {
        return new Iterator<T[]>() {
            int index = 0;
            final int L = arr.length;
            T[] sub = Arrays.copyOf(arr, K); // let it do the dirty work!

            @Override public boolean hasNext() {
                return index < L;
            }
            @Override public T[] next() {
                for (int i = 0; i < K; i++) {
                    sub[i] = arr[(index + i) % L];
                }
                index++;
                return sub; // we always overwrite; no need to .clone()
            }
            @Override public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }   
    public static void main(String[] args) {
        String[] arr = { "s1", "s2", "s3", "s4", "s5", "s6" };

        Iterator<String[]> iter = circularIterator(arr, 4);
        while (iter.hasNext()) {
            System.out.println(Arrays.toString(iter.next()));
        }
    }
}