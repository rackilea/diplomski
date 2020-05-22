int intCount = 100_000_000;
    int x[] = new int[intCount];
    Random rand = new Random();
    for (int i = 0; i < intCount; i++) {
        x[i] = rand.nextInt();
    }

    long ts = System.currentTimeMillis();

    for (int r = 0; r < 100; r++) {
        Arrays.stream(x).parallel().sum();
    }

    System.out.println("Time elapsed: " + (System.currentTimeMillis() - ts));