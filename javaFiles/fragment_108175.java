public static ArrayList<String> getImages()
    {
        String path = android.os.Environment.getExternalStorageDirectory() + "/Pictures/SanPics2/";
        File mainfolder = new File(path);
        ArrayList<String> files = new ArrayList<String>();
        if(mainfolder.listFiles() == null)
        return null;
        for(File f : mainfolder.listFiles())
        {
            if(f.getName().contains(".jpg"))
            {
                files.add(f.getAbsolutePath());
            }
        }
        return files;
    }