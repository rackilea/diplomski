public static void main(String[] args) {
    MyInteger val1 = new MyInteger(2);
    int val = 2;
    System.out.println("The value of this object is " + val1.getValu());
    val1.isEven();
    val1.isOdd();
    val1.isPrime();
    isEven(val1); // <-- here is the problem.
}