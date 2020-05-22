File mydir = new File(Environment.getExternalStorageDirectory() + "/" +directoryName); //Creating an internal dir; 
    if(!mydir.exists())
        mydir.mkdir();

    File fileWithinMyDir = new File(mydir, fileName+".pList"); //Getting a file within the dir. 
    FileOutputStream fos = new FileOutputStream(fileWithinMyDir);