public static void main(String[] args)  throws FileNotFoundException 
{
    // get the filename
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the name of the file: ");
    String filename = keyboard.nextLine();

    keyboard.close(); // <- don't forget to close this resource

    File file = new File(filename);
    //Scanner inputFile = new Scanner(file); // <- this line is unnecessary, because you never use that variable

    lines(file); // <- you already obtained a File object, so use it ;)
    words(file);
    characters(file);
}