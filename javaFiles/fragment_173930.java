public static void characters(File file)  throws FileNotFoundException 
{
    Scanner inputFile = new Scanner(file);
    int characters = 0;
    int count = 0; // new variable to count the characters

    while (inputFile.hasNextLine())
    {
        String line = inputFile.nextLine();
        for(int i = 0; i < line.length(); i++)
        {
            characters = line.charAt(i); // <- no harm in using a new line :)
            if (characters != 32) // <- you wrote "character"
            { 
                count++; // <- "characters" is the current character itself, we won't increase that. For example "a" would become "b" and we don't want/need that :)
            }
        }
    }
    //return characters; // <- you know that already ...
    inputFile.close();

    //System.out.println("The number of lines is: " + lines); // <- "lines" and "words" are unknown here, but we printed these results already
    //System.out.println("The number of words is: " + words);
    System.out.println("The number of characters is: " + count); // <- print the count of characters
    System.out.println();
}