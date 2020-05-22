for (int i1 = 0; i1 <= 10; i1++) {
        for (int i2 = 0; i2 < 34; i2++) {
            int i3 = 100 - i2 - i1;
            int total = i1 * 10 + i2 * 3 + i3 / 2;
            if (total == 100 && i3 % 2 == 0)
                System.out.println(i1 + " * 10 + " + i2
                        + " * 3 + " + i3 + " * 0.5 = 100");

        }
    }