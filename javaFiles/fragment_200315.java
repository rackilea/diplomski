public static void main(String[] args) {
    String number = "123456";

    int sum = 0;
    for (char c : number.toCharArray()) {
        sum = sum - (0 - c) - '0';
        while (sum >= 3) {
            sum -= 3;
        }
    }
    System.out.print("divisible by 3? ");
    System.out.println(sum == 0);
}