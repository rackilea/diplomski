public static void main(String[] args) {
    char index;
    Scanner kb = new Scanner(System.in);
    System.out.print("Enter desired character to find its index: ");
    index = kb.nextLine().charAt(0);
    final String quote = ("Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time. Thomas A. Edison");
    for (int i = 0; i < quote.length(); i++) {
        if (quote.charAt(i) == index) {
            System.out.println(i);
        }
    }
}