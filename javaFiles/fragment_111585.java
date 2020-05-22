public static void main(String[] args) {
    int[] data = { 1,2,3 };
    do {
        System.err.println(Arrays.toString(data));
    } while(Util.permuteLexically(data));
}