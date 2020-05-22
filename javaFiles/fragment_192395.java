int[] range = { 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 6};
    for (int i = 0; i < range.length; i++) {
        int j = i + 1;
        for (; j < range.length && range[i] == range[j]; j++) {
            // do nothing
        }

        if (j >= i + 2) {
            System.out.println(range[i]);
            i = j;
        }

    }
}