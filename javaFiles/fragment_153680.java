public class DeleteOnCloseFileInputStream extends FileInputStream {
   private File file;
   public DeleteOnCloseFileInputStream(String fileName) throws FileNotFoundException{
      this(new File(fileName));
   }
   public DeleteOnCloseFileInputStream(File file) throws FileNotFoundException{
      super(file);
      this.file = file;
   }

   public void close() throws IOException {
       try {
          super.close();
       } finally {
          if(file != null) {
             file.delete();
             file = null;
         }
       }
   }
}