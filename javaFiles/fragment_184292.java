public boolean openRead() throws FileNotFoundException
{
    boolean result = super.openRead();
    sc.useDelimiter(DELIMITERS);
    return result;
}