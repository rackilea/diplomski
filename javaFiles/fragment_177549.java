import java.util.Arrays;

public class Shuffle {
    /* assumes input and output arrays are same length (N) */
    static public <T> void perfectShuffle(T[] input, T[] output, int N)
    {
        int itop = 0;
        int ibottom = N - (N/2);
        /* bottom has (N/2) elements; for odd N this is rounded down,
         * and the top part has 1 more element */
        int k = 0;
        while (ibottom < N)
        {
           output[k++] = input[itop++];
           output[k++] = input[ibottom++];
        } 
        // handle last element for N = odd
        if (k < N)
           output[k] = input[itop];
    }

    public static void main(String[] args) {
        int N = 19;
        String[] in = new String[N];
        String[] out = new String[N];
        for (int i = 0; i < N; ++i)
            in[i] = Integer.toString(i);
        perfectShuffle(in, out, N);
        System.out.println(Arrays.asList(out));
    }
}