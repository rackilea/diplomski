public boolean isFibonacci(ArrayList<Integer> arr) {

    if (arr.size() < 3){
        return false;
    }

    /** find if the first element is part of the sequence: **/

    int fib1 = 0;
    int fib2 = 1;

    while (fib1 < arr.get(0)) {
        int tmp = fib1 + fib2;
        fib1 = fib2;
        fib2 = tmp;
    }

    if (fib1 != arr.get(0)) {
        // first element is not part of Fibonacci sequence
        return false;
    }

    if (fib2 != arr.get(1)) {
       // the first two elements are not part of the Fibonacci sequence
       return false;
    }

    /*** now simply verify that the rest of the elements uphold the rule:
         each element is the sum of the two previous ones: **/

    for(int i=2; i < arr.size(); i++) {

        // make sure there are no negatives in the array:
        if (arr.get(i) < 0)
           return false;

        if (arr.get(i) != (arr.get(i-1) + arr.get(i-2)))
           return false;

    }

    //everything checks out okay - return true:
    return true;
}