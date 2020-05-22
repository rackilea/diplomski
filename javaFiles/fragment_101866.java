public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
        System.out.print("Enter: ");
        long val = scan.nextLong();
        long t1 = System.currentTimeMillis();
        System.out.println(isPrime.test(val) ? "yes" : "no");
        System.out.println("took " + (System.currentTimeMillis() - t1) + " millis");
    }
}

static final LongPredicate isPrime = val -> {
    if (val < 2)
        return false;

    for (int i = 2, sqrt = (int)Math.sqrt(val); i <= sqrt; i++)
        if (val % i == 0)
            return false;

    return true;
};