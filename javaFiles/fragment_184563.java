public static String getAllEvens(int[] array) {
        String ret = "";

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ret += array[i] + " ";
            }
        }
        return ret;
    }