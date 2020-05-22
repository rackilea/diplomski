public void createDataBase() throws IOException
{
    //If database not exists copy it from the assets

    boolean mDataBaseExist = checkDataBase();
    if(!mDataBaseExist)
    {
        this.getReadableDatabase();
        this.close();
        try 
        {
            //Copy the database from assests
            copyDataBase();
            System.out.println("createDatabase database created");
        } 
        catch (IOException mIOException) 
        {
            throw new Error("ErrorCopyingDataBase");
        }
    }
}