File inputFile = (File) AccessController.doPrivileged(new PrivilegedAction() {
      public Object run() 
      {
         File inputFile1 = new File("C:\\Program Files\\MyFolder\\MyFile.jpg");
         return inputFile1;
      }
      });

  FileReader in = new FileReader(inputFile);