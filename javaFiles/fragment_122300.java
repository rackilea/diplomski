private void multiplyDigits(int[] result, int resultIndex,
                            int[] leftFactor, int[] rightFactor) {
    for(int i = 0; i < leftFactor.length; i++) {
        for(int j = 0; j < rightFactor.length; j++) {

            multiplyDigit(result, resultIndex - (i + j),
                          leftFactor[leftFactor.length-i-1],
                          rightFactor[rightFactor.length-j-1]);
        }
    }
}