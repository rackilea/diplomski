long p = (long)Math.pow(10, 8);
    long start = 90 * p;
    long end = 180 * p;
    for (long i = start; i < end; i++) {
        for (long j = start; j < end; j++) {
            System.out.println("(" + (double)i / p + "," + (double)j / p + ")");
        }
    }