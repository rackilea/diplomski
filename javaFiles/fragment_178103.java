public static int searchCount(File fileA, String fileWord) throws FileNotFoundException
{
    int count = 0;
    fileWord = fileWord.trim();
    Scanner scanner = new Scanner(fileA);

    while (scanner.hasNext()) // Fix issue #2
    {
        String nextWord = scanner.next().trim();
        if (nextWord.equals(fileWord)) { // Fix issue #1
            ++count; 
        }
    }
    //End While 
    return count;
}