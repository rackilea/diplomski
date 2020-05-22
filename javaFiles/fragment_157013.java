public static boolean isSimilar(int a, int b) {
    int abs = Math.abs(a-b);
    if (abs == 0) {
        return true;
    } else if (abs > 10) {
        return false;
    } else if (abs <= 5){
        int c = a/0; //ArithmeticException: / by zero (your semi-true)
        return true; 
    } else {
        Integer d = null;
        d.intValue(); //NullPointer Exception (your semi-false)
        return false;
    }
}