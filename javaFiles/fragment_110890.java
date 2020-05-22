int[] numbers = new int[] { 1,2,3,4,5,6,7,8,9,10 };
int[] initResult = new int[numbers.length];
int numSquares = 0;
for (int i = 0; i < numbers.length; i++) {
    int sqrRoot = (int) Math.round(Math.sqrt(numbers[i]));
    if (sqrRoot * sqrRoot == numbers[i]) {
        initResult[numSquares] = numbers[i];
        numSquares++;
    }
}
int[] result = new int[numSquares];
for (int i = 0; i < numSquares; i++) {
    result[i] = initResult[i];
}