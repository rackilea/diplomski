import java.io.File;

import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;

public class SystemFileItem extends TreeItem<String> {

    /** Stores the full path to the file or directory */
    private String fullPath;
    private boolean isDirectory;

    /**
     * Constructor
     * 
     * @param path
     */
    public SystemFileItem(String path) {
        super(path);
        this.fullPath = path;

        // test if this is a directory and set the icon
        if (new File(fullPath).isDirectory()) {
            isDirectory = true;
            //setGraphic(new ImageView(SystemFilesTree.folderImage));

        } // if you want different icons for different file types this is
            // where you'd do it
        else {
            isDirectory = false;
            //setGraphic(new ImageView(SystemFilesTree.fileImage));
        }

        // set the value
        if (!fullPath.endsWith(File.separator)) {
            // set the value (which is what is displayed in the tree)
            String value = path;
            int indexOf = value.lastIndexOf(File.separator);
            if (indexOf > 0) {
                this.setValue(value.substring(indexOf + 1));
            } else {
                this.setValue(value);
            }
        }
    }

    public String getFullPath() {
        return fullPath;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}