File checkFile = new File(".checkfile");
if(!checkFile.exists() || !checkFile.isFile()){
   // file does not exist, so this is the first time running the program.
   // create the file so that we know we have already run the next time
   Files.createFile(checkFile.toPath());
} else {
  // This file exists, we already ran the program previously
}