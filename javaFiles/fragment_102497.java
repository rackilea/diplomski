public static int smallestNonRepresentable(int[] nbAllowed) {
    int n=0;
    while (isRepresentable(n, nbAllowed)) {
        n++;
    }
    return n;
}