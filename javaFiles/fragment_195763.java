public static void main(String[] args) {
    for (int i = 0; i < 64; i++) {
        long x = 1L << i;
        check(x);
        check(x-1);
    }
}

static void check(long x) {
    int correct = 64 - Long.numberOfLeadingZeros(x);
    int floated = (int) (1 + Math.floor(Math.log(x) / Math.log(2)));
    if (floated != correct) {
        System.out.println(Long.toString(x, 16) + " " + correct + " " + floated);
    }
}