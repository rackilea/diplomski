File dir= new File("path");
File[] fileList = dir.listFiles(new FilenameFilter() 
{
    public boolean accept(File dir, String foundFileName) 
   {
        return name.equalsIgnoreCase(foundFileName);
   }
});