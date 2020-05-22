public static void words(File file)  throws FileNotFoundException // <- new argument type
{
    Scanner inputFile = new Scanner(file);
    int words = 0;

    while (inputFile.hasNextLine())
    {
        //String word = inputFile.next(); // that won't work like you think, but we can do a little "trick" here
        String line = inputFile.nextLine(); // read the current line of text
        words += line.split(" ").length; // split the line using whitespace and add the number of words to the current value of variable "words"

        //words++; // <- not needed anymore
    }
    //return words; // <- like before: not possible if return type is void

    inputFile.close();

    //your comment on that method says that you like to print the result, so let's do that
    System.out.println("The number of words is: " + words);
}