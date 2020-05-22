public void findIntervalSumOf(int sum, int[] values){
    for (int i = 0, size = values.length; i < size; i++){
        int currentSum = values[i];
        for (int j = i+1; j < size; j++){
             currentSum += values[j];
             if (currentSum == sum) {
                System.out.println(String.format("start: %d end %d", i, j));
             } else if (currentSum > sum) {
                break;
             }

        }
    }
}