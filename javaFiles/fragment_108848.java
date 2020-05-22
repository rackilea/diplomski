long t0, t1, tt = 0L;
for (int i = 0; i < ITERATIONS; i++) {
    t0 = System.currentTimeMillis();
    //- Execute the code its execution time you want to measure here.
    t1 = System.currentTimeMillis();
    tt += (t1 - t0);
}
System.out.println("Total time: " + tt + "ms");