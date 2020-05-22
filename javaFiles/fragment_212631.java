static void getLargest(int[] array1) {
        int c;
        int d = array1[0];
        for (c = 0; c <= 9; c++) {
            if (d < array1[c]) {
                d = array1[c];
            }
        }
        System.out.println("The highest value is: " + d);
    }