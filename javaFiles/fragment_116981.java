double d = 81.2384;
    double l1 = 0, l2 = 0;
    Long start = System.nanoTime();

    for (int i = 0; i < 1000 * 1000 * 100; i++) {
        l1 = d - d % 0.1;
    }
    Long time = System.nanoTime();
    Long l1speed = time - start;
    for (int i = 0; i < 1000 * 1000 * 100; i++) {
        l2 = (int) (d * 10) * 0.1;
    }
    Long l2speed = System.nanoTime() - time;

    System.out.println(l1 + l2); //to be sure that compiler does not ignore l1, l2
    System.out.println("computing l1 runs :" + ((double)l1speed / l2speed)+"faster than computing l2");