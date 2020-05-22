FileOutputStream out = null;
try
{
    out = new FileOutputStream("myfile.txt");
    // More and more code goes here...
}
catch (Exception e)
{
}
finally 
{
    closeStream(out);
}