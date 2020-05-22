long start = System.nanoTime();
    //time consuming code here.
    //...
    long end = System.nanoTime();
    long used = end-start;
    System.out.println("used:"+TimeUnit.NANOSECONDS.toMillis(used)+" ms");