static void RecursiveFolderFinder(String Root)
{
    Iterator<Folder> Folder = ListOfFolders.iterator();
    while (Folder.hasNext())
    {
        Folder curFolder = Folder.next();
        if (curFolder.getParent().equals(Root))
        {
            OutputList += " " + curFolder.getName() + " ";
            OutputList += "{";
            RecursiveFolderFinder(curFolder.getName());
            if (OutputList.substring(OutputList.length()-1, OutputList.length()).equals("{"))
                OutputList = OutputList.substring(0, OutputList.length()-1);
            else if (!OutputList.substring(OutputList.length()-1, OutputList.length()).equals(" "))
                OutputList += " }";
            else
                OutputList += "}";
        }
    }
}