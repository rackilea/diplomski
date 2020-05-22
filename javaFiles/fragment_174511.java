public void writeToFile(String outFilename) throws FileNotFoundException
{
    PrintWriter outFile = new PrintWriter(outFilename);
    for (int i=0; i<words.size(); i++)
        outFile.println(words.get(i));
    outFile.flush(); // strictly redundant
    outFile.close();
}