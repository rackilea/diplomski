public static void main(String[] args) throws Exception {
    System.out.println("What is your secret message?");
    Scanner scan = new Scanner(System.in);
    String strMessage = scan.nextLine();

    for (int i = 0; i < strMessage.length(); i++) {
        System.out.print((int) strMessage.charAt(i));
    }
    System.out.println();

    // Java 8
    strMessage.chars().forEach(c -> System.out.print(c));
    System.out.println();

    // Binary output
    for (int i = 0; i < strMessage.length(); i++) {
        System.out.print("0"+Integer.toBinaryString((int)strMessage.charAt(i)));
    }
    System.out.println();

    // Java 8 Binary output
    strMessage.chars().forEach(c -> System.out.print("0"+Integer.toBinaryString(c)));
    System.out.println();
}