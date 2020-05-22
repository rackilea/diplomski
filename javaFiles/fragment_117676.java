fo.addFileChangeListener(new CustomFileChangeListener());

public class CustomFileChangeListener implements FileChangeListener {
    @Override
    public void fileChanged(FileEvent fe) {
       ... file has been saved in the editor, sync with database ...
    }
}