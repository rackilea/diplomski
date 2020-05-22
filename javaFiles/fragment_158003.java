public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int n3 = in.nextInt();

    int max = findMax(n1, n2, n3);
    System.out.println("Maximum: " + max);

    System.out.println("Minimum: " + findMin(n1, n2, n3));
}

public static int findMax(int n1, int n2, int n3) {
    int maximum = Math.max(n1, n2);
    int maximum2 = Math.max(maximum, n3);
    System.out.println("The maximum is " + maximum2);
    return maximum2;
}

public static int findMin(int n1, int n2, int n3) {
    int minimum = Math.min(n1, n2);
    int minimum2 = Math.min(minimum, n3);
    System.out.println("The minimum is " + minimum2);
    return minimum2;
}