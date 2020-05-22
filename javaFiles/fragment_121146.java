public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Testing Scanner, write something: ");
    String testi = scan.nextLine();
    testi = testi.toUpperCase();
    char[] ascii1 = testi.toCharArray();
    int sum = 0;
    for (char ch : ascii1) {
        sum += ch;
    }
    System.out.println("Sum: " + sum);
    scan.close();
}