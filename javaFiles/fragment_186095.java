System.out.println("R_HOME =" + System.getenv("R_HOME"));
  String path =System.getenv("R_HOME") + "\\library" ;
   File folder = new File(path);
  File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }