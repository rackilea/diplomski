public static void main(String[] args) throws IOException
{
    Scanner scanner = new Scanner(System.in);
    String line;

    System.out.println("Enter names (\"QUIT\" to finish)");
    while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        if (line.equals("QUIT")) {
            break;
        }
    }
    // ...
}