private static void printConvertedNumber(int num, int base) {
    if (num <= 0) {
        return;
    }
    printConvertedNumber(num / base, base);
    System.out.print(num % base);
}