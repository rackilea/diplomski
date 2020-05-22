public static int findSum() {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter total input ");
    int n = s.nextInt();
    int arr1 [] = new int[n];
    int sum = 0;

    System.out.println("Enter the " + n + " inputs ");
    for (int i = 0; i < n; i++) {
        arr[i] = s.nextInt();
        if (arr[i] % 2 == 0 || arr[i] % 3 == 0) {
            sum = sum + arr[i];
        }
    }

    return sum;
}