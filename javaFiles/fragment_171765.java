List<String> directoryNames = new ArrayList<>();

for(int i = 0; i < directories.size(); i++){

   // Instead of using "/", use File.separatorChar because separator char
   // is dependent with the system. 
   int index = directories.get(i).lastIndexOf(File.separatorChar);

   // check only for valid directory name.
   if(index >= 0) {
      // don't include the "/" as the name
      String lastLevel = directories.get(i).substring(index + 1);
      directoryNames.add(lastLevel);
   }

}