public void benchmark() throws Exception {
    Random rnd = new Random();
    int nIterations = 10000;
    //let the JIT to optimize something
    for (int att = 0; att < nIterations; att++) {
        long[] data = new long[1000];
        for (int i = 0; i < data.length; i++)
            data[i] = rnd.nextLong();

        long denominator = rnd.nextLong();

        long[] slow = data.clone();
        long start = System.nanoTime();
        reduceArraySlow(slow, denominator);
        long slowTime = System.nanoTime() - start;


        long[] fast = data.clone();
        start = System.nanoTime();
        reduceArrayFast(fast, denominator);
        long fastTime = System.nanoTime() - start;

        Assert.assertArrayEquals(slow, fast);

        // print last 100 timings (JVM already warmed up)
        if (att > nIterations - 100) {
            System.out.println("\"/\" operation: " + slowTime);
            System.out.println("Fast division: " + fastTime);
            System.out.println("");
        }
    }
}