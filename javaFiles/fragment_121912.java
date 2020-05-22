long time = 0; 
    for(int i=0; i<1000000; i++) {
        double d1 = rnd.nextDouble();
        double d2 = rnd.nextDouble();
        long start = System.nanoTime();
        t = d1 * d2;
        long end = System.nanoTime();
        time += (end-start)
    }
    long meantime = time / 1000000;