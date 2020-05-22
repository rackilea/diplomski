first: {
        System.out.println("First statement");
        for (int i = 0; i < 2; i++) {
            System.out.println("Second statement");
            break first;
        }
    }