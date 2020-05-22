for (int counter = 0; counter < 10; ++counter) {

        int count = 0; // count is reset to 0 every loop
        for (int i = 0; i < 4; i++) {
            es.execute(new FooWorker());
        }

        count = count + 1; // count will always be 1 here
        System.out.println((count * 4) + "," + count + " threads created");

    }