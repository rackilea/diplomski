File file = new File(Environment.getExternalStorageDirectory()
     +File.separator
     +"myDirectory" //folder name
     +File.separator
     +"myFile.png"); //file name
   file.getParentFile().mkdirs();