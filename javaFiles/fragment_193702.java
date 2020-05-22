public static void main(String[] args) {
    final Scanner input = new Scanner(System.in);
    System.out.println("Enter a character to get value of it:");
    String inputString =  input.next();
    // Print -1 on an empty input
    final OptionalInt codepoint = inputString.codePoints().findFirst();
    System.out.println(codepoint.isPresent() ? codepoint.get() : -1);
}