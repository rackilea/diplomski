while ((line = reader.readLine()) != null)
{
    myTokens = new StringTokenizer(line, ",");

    list = new String[myTokens.countTokens()];

    int i = 0;

    while (myTokens.hasMoreTokens())
    {
        list[i] = myTokens.nextToken();
        i++;
    }
}