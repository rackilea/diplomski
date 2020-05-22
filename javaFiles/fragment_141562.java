for (int i = 0; i < array.length; i++) {
        array[i] = createRandom();
        while (array[i] == 0) {
            array[i] = createRandom();
        }
        if (positiveCounter >= array.length / 2 && array[i] > 0) {
            array[i] = array[i] * -1;   // Force the number to be negative
        }
        if (negativeCounter >= array.length / 2 && array[i] < 0) {
            array[i] = array[i] * -1;   // Force the number to be positive
        }
        if (array[i] > 0) {
            positiveCounter++;
        }
        if (array[i] < 0) {
            negativeCounter++;
        }
 }