public static void main(String[] args) {
    MyInteger val1 = new MyInteger(2);
    int val = 2;

    MyInteger.isEven(val1);
    val1.isEven(val1);

    MyInteger.isEven(val);
    val1.isEven(val);
}