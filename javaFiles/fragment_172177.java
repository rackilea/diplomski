class FileManager {
   private CompletionService<FileSummary> cs; // Initialize this in constructor

   public FinalResult processDir(File dir) {
      int fileCount = 0;
      for(File f : dir.listFiles()) {
         cs.submit(new FileProcessor(f));
         fileCount++;
      }

      for(int i = 0; i < fileCount; i++) {
         FileSummary summary = cs.take().get();
         // aggregate summary into final result;
      }
   }