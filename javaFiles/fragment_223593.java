import com.apple.eawt.*;

public class MyMainClass {
  private static boolean listenerRegistered = false;

  public static void main(String[] args) throws Exception {
    if(!listenerRegistered) {
      Application.getApplication().setOpenFileHandler(new OpenFilesHandler() {
        public void openFiles(AppEvent.OpenFilesEvent evt) {
          List<String> filenames = new ArrayList<String>();
          for(File f : evt.getFiles()) {
            filenames.add(f.getAbsolutePath());
          }
          MyMainClass.main(filenames.toArray(new String[filenames.size()]));
        }
      });
      listenerRegistered = true;
    }

    // rest of main goes here
  }
}