public static void main(String[] args) {
 double d = makeChange(0,0);

}

public static double makeChange(double itemCost, double dollarsProvided) {
    double change = dollarsProvided - itemCost ;
    return change;
}