...
for (File source : sources) {
   try {
      copyFile(source, dest);
   }
   catch (Exception ignore) {
      // ignore exception and continue
   }
   // do your other stuff here
}

private static void copyFile(File source, File dest)
        throws IOException {
    FileChannel inputChannel = null;
    FileChannel outputChannel = null;
    try {
        inputChannel = new FileInputStream(source).getChannel();
        outputChannel = new FileOutputStream(dest).getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } 
    finally{
       if (inputChannel != null) inputChannel.close();
       if (outputChannel != null) outputChannel.close();
    }
}