int tokenCount = 0;
int lineCount = 0;

while (scanLine.hasNextLine())
{
    String line = scanLine.nextLine();
    StringTokenizer tokenizer = new StringTokenizer(line);

    while (tokenizer.hasMoreTokens())
    {
        String string = tokenizer.nextToken();
        outFile.println(string);
        tokenCount++;
    }
}