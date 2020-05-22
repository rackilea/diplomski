public static void registerRecursive(Path root,WatchService watchService) throws IOException { 
   WatchServiceWrapper wsWrapper = new WatchServiceWrapper();

   // register all subfolders 
   Files.walkFileTree(root, new SimpleFileVisitor<Path>() { 
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
         wsWrapper.register(watchService, dir);
         return FileVisitResult.CONTINUE; 
      } 
   });  

   wsWrapper.processEvents();
}

public class WatchServiceWrapper {
   private final Map<WatchKey,Path> keys;

   public WatchServiceWrapper () {
      keys = new HashMap<>();
   }

   public void register(WatchService watcher, Path dir) throws IOException {
      WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
      keys.put(key, dir);
   }

   public void processEvents() {
      for (;;) {
        // wait for key to be signalled
        WatchKey key;
        try {
            key = watcher.take();
        } catch (InterruptedException x) {
            return;
        }

        Path dir = keys.get(key);
        if (dir == null) {
            System.err.println("WatchKey not recognized!!");
            continue;
        }

        //get fileName from WatchEvent ev (code emitted)
        Path fileName = ev.context();

        Path fullFilePath = dir.resolve(fileName);

        //do some other stuff
      }
   }
}