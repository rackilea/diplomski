public static void main(String[] args) {
    int sum = 0;
    for (String arg : args) {
        int number = Integer.parseInt(arg);
        System.out.println(number);
        sum += number;
        System.out.println(sum);
    }
}