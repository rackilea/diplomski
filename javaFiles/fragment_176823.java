File file = new File("C:\\Users\\User1\\Documents\\Folder1\\"+folderName+"\"");

    if(!file.exists())
    {
        file.mkdir();
    }