for (int i = 1; i < 10000; i++) {
        for (int t = 1; t < 10000; t++) {
            if (n * (i + t) == i * t) {
                counter++;
                System.out.println(counter);
            }
        }           
    }