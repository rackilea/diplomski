File newfile = new File(fileName.substring(0, 21) + "hello world.txt");
    if (!oldfile.exists())
    {
        try
        {
            oldfile.createNewFile();
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    else
    {

        if (oldfile.renameTo(newfile))
        {

            System.out.println("Rename succesful");
        }
        else
        {
            System.out.println("Rename failed");
        }
    }