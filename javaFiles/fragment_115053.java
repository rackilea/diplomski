// print all numbers with n digits
public static void printBinaryNumber(int n){
    // print all numbers with n digits recursively adding ""
    printBinaryNumbersRec("", n);
}

public static void printBinaryNumbersRec(String s, int n){
    if(n < 0) throw new IllegalArgumentException();
    if(n == 0) {
        // if I should print all numbers with 0 digits and add s before them
        // I just print s and am done
        System.out.println(s);
        return;
    }
    // add an additional 0 to s and print all numbers with n-1 digits
    printBinaryNumbersRec(s + "0", n-1);
    // add an additional 1 to s and print all numbers with n-1 digits
    printBinaryNumbersRec(s + "1", n-1);
}