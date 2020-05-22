public static void main(String[] args) {
    Scanner reader = new Scanner(System.in); // Declare and initialize reader
    System.out.print("Type in your text: ");
    String text = reader.nextLine();
    System.out.println("In reverse order: " + reverse(text));
}