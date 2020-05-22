//Asks for input file
public static Scanner asksForFile(Scanner scanner, PrintStream output) throws FileNotFoundException {
    output.print("input file name? ");
    String filename = input.nextLine();
    return new Scanner(new File(filename));

}