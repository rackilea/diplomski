String line;
while ((line = readInput.readLine()) != null)
{
    StringTokenizer tokenizer = new StringTokenizer(line);

    while (tokenizer.hasMoreTokens())
    {
        String string = tokenizer.nextToken();
        outFile.println(string);
        tokenCount++;
    }
}