try
{
    myscanner = new Scanner(new File("file.txt"));
    //now do your processing inside here
}
catch (FileNotFoundException e)
{
    e.printStackTrace();
}