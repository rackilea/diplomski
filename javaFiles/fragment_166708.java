static int counter = 0;

public static int getPossibleStepCombination(int n) {
    Integer[] memo = new Integer[n+1];
    return getNumOfStepCombos(n, memo);
}

private static int getNumOfStepCombos(int n, Integer[] memo) {
    counter++;
    if(n < 0) return 0;
    if(n == 0) return 1;
    if(memo[n] != null) return memo[n];
    memo[n] = getNumOfStepCombos(n - 1, memo) + getNumOfStepCombos(n - 2, memo) + getNumOfStepCombos(n-3,memo);
    return memo[n];
}

public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        counter = 0;
        getPossibleStepCombination(i);
        System.out.print(i + " => " + counter + ", ");
    }
}