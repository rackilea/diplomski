public static void main(String[] args) {
    long binaryNumber = 10011;
    int shift = 0;

    while(shift < 6)
        System.out.println(circularShiftBinary(binaryNumber, shift++));
}//main method