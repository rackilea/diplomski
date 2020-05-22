public static void main(String[] args) {
    int T, N;
    System.out.println("Enter number of test cases: ");
    Scanner in = new Scanner(System.in);
    T = in.nextInt();

    String configuration1;

    for (int i = 0; i < T; i++) {
        System.out.println("Enter the configuration: ");
        configuration1 = in.next();
        System.out.println("The configuration is: " + configuration1);
    }
}