static boolean checkNum(int[] array) {

    for (int i = 0; i < array.length; i++) {

        if (array[i] != 1 && array[i] != 4) {
            return false;
        }

    }

    return true;
}