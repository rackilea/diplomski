private boolean isPresent(int[] arrayValues, int a, int b) {
        boolean isPresent = false;
        int i = 0;
        while (!isPresent && i < arrayValues.length )) {
            isPresent = a < arrayValues[i] && arrayValues[i] < b;
                         i++;
        }

        return isPresent;
    }