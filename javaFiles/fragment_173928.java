public static void lines(File file)  throws FileNotFoundException // mind the new argument type
{
    Scanner inputFile = new Scanner(file);
    int lines = 0;

    while (inputFile.hasNextLine())
    {
        lines++;
        inputFile.nextLine(); //<- use "inputFile" instead of "file"
    }
    inputFile.close();
    //return lines; // <- you can't return something if your method uses "void" as the return type

    //your comment on that method says that you like to print the result, so let's do that
    System.out.println("The number of lines is: " + lines);
}