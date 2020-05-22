// Run several times to *warm up*
for (int i = 0; i < 100; i++) {
    double init = System.nanoTime();
    Thread.sleep(1);
    long end = System.nanoTime();
    System.out.printf("Elapsed time: %.2f milliseconds\n", (end - init) * 1e-6); 
}