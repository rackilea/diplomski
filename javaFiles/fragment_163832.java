public static String test_method() {
    int[] array1 = {1, 2, 3};
    int[] array2 = {3, 4};

    String string = "";

    for (int i: array1) {
        for (int j: array2) {
            String sub = "(" + String.valueOf(i) + ", " 
                             + String.valueOf(j) + ") ";
            string += sub;
        }
    }

    return string;
}