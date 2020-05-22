public Dictionary(String inputFilename) throws FileNotFoundException 
{
    Scanner inFile = new Scanner(new FileReader(inputFilename));
    words = new ArrayList <String>();

    while (inFile.hasNext()) { 
        words.add(inFile.next().toLowerCase().replaceAll("[^a-zA-Z ]", ""));
    }
    inFile.close();

    removeDuplicates();

    Collections.sort(words);
}