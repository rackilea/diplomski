private static long digitProcessSystem(long N) {
    long numberN = N;
    String number = Long.toString(N);
    // calculate 10 digits number here yet
    if (number.length() < 10) {
        // using the smallest possible number with each digit
        // By using this number we are most likely allmost at the result
        // This will increase the performance for small digits heavily.
        long divider = 1023456789L / numberN;
        numberN *= divider;
    }
    number = Long.toString(numberN);
    String[] arr = number.split("");
    Set<String> input = new HashSet<>(Arrays.asList(arr));
    while(input.size() != 10){
        // add N to number
        numberN += N;
        // Parse the new number
        number = Long.toString(numberN);
        // split
        arr = number.split("");
        // clear set
        input.clear();
        // Add the new numbers to the set. If it has the size 10 now the loop will stop and return the number.
        input.addAll(Arrays.asList(arr));
    };
    return numberN;
}

public static void main(String[] args) {
    System.out.println(digitProcessSystem(123));
}