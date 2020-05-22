File theFile = new File(pathToFile);
try
{
    Scanner fileContent = new Scanner(theFile);
    List<DataHolder> dataList = new ArrayList<DataHolder>();
    List<String> stringList = new ArrayList<String>();
    while(fileContent.hasNextLine())
    {
        stringList.add(fileContent.nextLine());
        if(line.equals(""))
        {
            if (!stringList.isEmpty())
            dataList.add(new DataHolder(stringList));
            stringList.clear();

        }
    }  
}
catch(Exception e)
{
    // ToDo
}