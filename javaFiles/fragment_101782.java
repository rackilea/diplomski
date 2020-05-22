public static void main(String[] args) {
    int sum = 0;
    for(int num = 0;num <= 1000;++num) {
        if (num % 13 == 0 || num % 15 == 0 || num % 17 == 0) {
            if (num % 30 != 0) {
                sum = sum + num;
            }
        }
    }
    System.out.println("Sum = " + sum);

}