public static void main(String[] args) {
    int N = 52;
    String[] in = new String[N];
    String[] out = new String[N];
    for (int i = 0; i < N; ++i)
        in[i] = Integer.toString(i);

    for (int k = 0; k < 8; ++k)
    {
        perfectShuffle(in, out, N);
        System.out.println(Arrays.asList(out));

        String[] tmp = in;
        in = out;
        out = tmp;          
    }
}