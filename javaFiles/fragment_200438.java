private static File findFile(File dir, String name) {
  File result = null; // no need to store result as String, you're returning File anyway
  File[] dirlist  = dir.listFiles();

  for(int i = 0; i < dirlist.length; i++) { 
    if(dirlist[i].isDirectory()) {
      result = findFile(dirlist[i], name);
      if (result!=null) break; // recursive call found the file; terminate the loop
    } else if(dirlist[i].getName().matches(name)) {
      return dirlist[i]; // found the file; return it
    }
  }
  return result; // will return null if we didn't find anything
}