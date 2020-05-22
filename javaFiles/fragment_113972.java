DatabaseHandler db = new DatabaseHandler(context);
   try 
    {
        db.createDataBase();
    } 
    catch (IOException io) 
    {
        throw new Error("Unable to create database");
    }