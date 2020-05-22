public static void main(String[] args) {
    Scanner first = new Scanner(System.in);
    Scanner second = new Scanner(System.in);
    int x = first.nextInt();
    int y = second.nextInt();
    System.out.println("First scan returns: " + x);
    System.out.println("Second scan returns: " + y);
    first.close();
    second.close();
}