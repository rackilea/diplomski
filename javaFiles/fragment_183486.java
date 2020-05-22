int[] array = { 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,....,100};
     int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            System.out.print(array[i]+" ");
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }