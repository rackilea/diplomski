String uni = "Uniques: ";
    String dup = "Duplicates: ";

    int[] range = { 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 6};

    for (int i = 0; i < range.length; i++) {
        if (i + 1 < range.length && range[i + 1] == range[i]) {
            dup += range[i] + " ";

            int j = i + 1;
            while (j < range.length && range[i] == range[j]) {
                j++;
            }
            i = j - 1;
        } else {
            uni += range[i] + " ";
        }
    }

    System.out.println(uni);
    System.out.println(dup);