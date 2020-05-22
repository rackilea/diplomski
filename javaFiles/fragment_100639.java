public class FileWatcher {

      private Timer timer;

      public FileWatcher(File path) {

           timer = new Timer("FileWather", true);
           // Schedule task to start immeditaly and re-fire every second...
           timer.scheduleAtFixedRate(new FileWatcherTask(), 0, 1000);

      }

      public void addFileWatcherListener(FileWatcherListener listener) {
           //...
      }

      public void removeFileWatcherListener(FileWatcherListener listener) {
           //...
      }

      protected void fireFileRemoved(File... files) {
           //...
      }

      protected void fireFileAdded(File... files) {
           //...
      }

      protected void fireFileChanged(File... files) {
           //...
      }

      public class FileWatcherTask extends TimerTask {

           @Override
           public void run() {
                // Look ma, no hands!
           }

      }

 }