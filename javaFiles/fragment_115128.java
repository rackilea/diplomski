public void processFiles() {
    File dir = new File("/tmp/");
       if (dir.isDirectory()) {
          final File[] files = dir.listFiles();
          for (File file : files) {
             myMethod(file);
          }
       }
}

private void myMethod(File file) {
   // do what you need here with the file
}