private void extractFiles(String folder) {
  //get the files for a given folder
  files = codeThatGetsFilesAndDirs(folder);

  for(file in files) {
    if(file.isDirectory()) {
      extractFiles(file.getName()); 
    } else {
      //code to extract the file and writes it to disk.
    }
  } 
}