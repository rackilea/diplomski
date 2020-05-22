final int[] values = {1, 2, 3, 4};
    for (int size = 2; size < values.length; size++) {
        for (int i = 0; i + size <= values.length; i++) {
            for (int j = 0; j <= size - 1; j++) {
                System.out.print(values[i + j]);
            }
            System.out.println();
        }
    }