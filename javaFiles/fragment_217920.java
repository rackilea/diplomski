Scanner myscanner= null;
try
{
    myscanner = new Scanner(new File("file.txt"));
}
catch (FileNotFoundException e)
{
}