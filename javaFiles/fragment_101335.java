public void maxDistance(int inputArray[]) {
        int currentMin = inputArray[0],     currentMinIndex = 0;
        int trueMaxValue = 0,   trueMinIndex = 0,   trueMaxIndex = 0;
        int tempMaxValue;

        int i = 1;
        while (i < inputArray.length) {
            tempMaxValue = inputArray[i] - inputArray[currentMinIndex];
            if (tempMaxValue > trueMaxValue) {
                trueMaxValue = tempMaxValue;
                trueMinIndex = currentMinIndex;
                trueMaxIndex = i;
            }

            if (inputArray[i] < currentMin) {
                currentMinIndex = i;
                currentMin = inputArray[i];
            }

            ++i;
        }