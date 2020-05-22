out:
    for (int i = 0; i < 5; i++) {
        System.out.println("outer loop");
        for (int j = 0; j < 5; j++) {
            System.out.println("inner loop: " + ++counter);
            if (counter == 11) {
                break out;
            }
        }
    }