public static void main(String[] args) {
    boolean ifResult = lambdaIf(
            (pInt) -> { //Call lambdaIf with a function
                if(pInt == 0) { //Our lambda has an if-case for its input
                    return true;
                } else {
                    return false;
                }
            }
    );

    System.out.println(ifResult);
}

public static boolean lambdaIf(IntPredicate function) {
    if(function.test(0)) { //Evalutate the function and use the result in an if
        return true;
    }
    return false;
}