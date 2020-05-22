try
{
    g.drawString("1", 50, 50);
    arrayArray = getBits();
    throw new FileNotFoundException();
}
catch(FileNotFoundException e)
{

}
finally
{
    g.drawString("end", 75, 75);
}