public String lookUpEntry(String name){
    for(DirectoryEntry e : theDirectory)
      if(e.getName().equals(name))
        return e.getNumber();
    return null;  //Could not find name
}