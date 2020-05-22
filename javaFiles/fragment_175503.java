Set<Path> sourcesSet = new HashSet<>();
boolean addNewSourceToSet(File src) throws IOException
{
    Path newPath = src.toPath();
    // See if contained exactly
    if(sourcesSet.contains(newPath))
    {
        return true;            
    }
    Path parent = newPath.getParent();

    while(parent != null)
    {
        if(sourcesSet.contains(parent))
        {
            return true;
        }
        parent = parent.getParent();                    
    }
    sourcesSet.add(newPath);
    return false;
}