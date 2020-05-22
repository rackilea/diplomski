public static void printWithCommas(int num) {
    if (num > 999) {
        printWithCommas(num/1000);
        System.out.print(',');
        if (num % 1000 < 100) System.out.print('0');
        if (num % 1000 < 10) System.out.print('0');
        System.out.print(num%1000);
    }
    else {
        System.out.print(num);
    }
}