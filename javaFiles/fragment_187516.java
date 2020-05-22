public int getAverage(int[] randomArray) {
        int sum = 0;
        for (int index = 0; index < randomArray.length; index++) {
            sum = sum + randomArray[index];
        }
        int average = sum / randomArray.length;
        return average;
    }