public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Type anything: ");
    String text = keyboard.nextLine();

    Scanner scanner = new Scanner(text);
    // This is what will break the line apart
    scanner.useDelimiter("\\s?\\\\n\\s?");

    while (scanner.hasNext()) {
        System.out.println(scanner.next());
    }
}