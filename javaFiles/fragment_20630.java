import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import javafx.application.Platform;
import javafx.stage.FileChooser;


public class FileGetter {

    /**
     ** Retrieves a file from a JavaFX File chooser. This method can 
     ** be called from any thread, and will block until the user chooses
     ** a file.
     **/

    public File getFile() throws InterruptedException {

        FXStarter.startFXIfNeeded() ;

        if (Platform.isFxApplicationThread()) {
            return doGetFile();
        } else {
            FutureTask<File> task = new FutureTask<File>(this::doGetFile);
            Platform.runLater(task);
            try {
                return task.get();
            } catch (ExecutionException exc) {
                throw new RuntimeException(exc);
            }
        }
    }

    private File doGetFile() {
        File file = null ;
        FileChooser chooser = new FileChooser() ;

        while (file == null) {
            file = chooser.showOpenDialog(null) ;
        }

        return file ;
    }
}