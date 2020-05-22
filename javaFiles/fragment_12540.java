try
{

    br = new BufferedReader(new FileReader(file));
    int ch = br.read();

    while(ch != -1)
    {
        publish(ch);
        ch = br.read();
    }
}
finally
{
    try
    {
        br.close();
    } catch (IOException e) { }
}
System.gc();
return null;