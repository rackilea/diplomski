public static String getAllEvens(int[] array) {
        StringBuilder evens = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens.append(array[i]).append(" ");
            }
        }
        return evens.toString();
    }