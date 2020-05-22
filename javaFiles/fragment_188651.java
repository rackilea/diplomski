try
{
    g.drawString("1", 50, 50);
    arrayArray = getBits();
}
catch(FileNotFoundException e)
{
    e.printStackTrace();
}
finally
{
    g.drawString("end", 75, 75);
}