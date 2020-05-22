static boolean checkNum(int[] array) {

    for (int i : array) {

        if (i != 1 && i != 4) {
            return false;
        }

    }

    return true;
}