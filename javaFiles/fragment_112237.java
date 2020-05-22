final String myfilename;
File inputFile = (File) AccessController.doPrivileged(new PrivilegedAction() {
      public Object run() 
      {
         File inputFile1 = new File(myfilename);
      }
    });
FileReader in = new FileReader(inputFile);