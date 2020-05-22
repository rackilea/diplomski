ArrayList<File> sources = new ArrayList<>();
boolean addNewSourceToList(File src) throws IOException
{
    Path newPath = src.toPath();
    for(File f : sources)
    {           
        if(newPath.startsWith(f.toPath()))
        {
            return true;            
        }   
    }
    sources.add(src);
    return false;
}