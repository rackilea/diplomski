float delay = (float)5000;
        long startTime = System.nanoTime();
        int elapsed = 0;
        for (int i = 0; i < 20; i++) {
            elapsed = (int) ((System.nanoTime() - startTime) / 1000000);
//          System.out.println("Elapsed: " + elapsed);
            float range = delay * 0.4f;
            float randomNum = (float)(Math.random() * range - (delay * 0.2f));
            if (elapsed > (delay + randomNum)) {
                System.out.println("Random Num: " + randomNum);
                startTime = System.nanoTime();
            } else {
                i--;
                continue;
            }
        }