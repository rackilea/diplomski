private static final Map<Integer,Integer> previousResults = new HashMap<>();

private static int collatz(int n) {
    int result = 1;
    if(previousResults.containsKey(n)) {
        return previousResults.get(n);
    } else {
        if(n==1) result = 1;
        else if(n%2==0) result += collatz(n/2);
        else result += collatz(3*n + 1);
        previousResults.put(n, result);
        return result;
    }
}