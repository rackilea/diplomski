try
{
    String path = "/data/data/"+getPackageName()+"/test.json";
    File file = getFileStreamPath(path); 
    if (!file.exists())
    {
      file.createNewFile();
    }

    FileOutputStream writer = openFileOutput(file.getName(), Context.MODE_PRIVATE);
    writer.write(data.getBytes());//data is your json in String
    writer.flush();
    writer.close();
}
catch(Exception e)
{
    //exception
}