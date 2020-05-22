import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FilePathTreeItem extends TreeItem<String>{
    public static Image computer = new Image(ClassLoader.getSystemResourceAsStream("computer.png"));
    public static Image folderClosed = new Image(ClassLoader.getSystemResourceAsStream("folder.png"));
    public static Image folderOpened = new Image(ClassLoader.getSystemResourceAsStream("folder-open.png"));
    public static Image genericText= new Image(ClassLoader.getSystemResourceAsStream("text-x-generic.png"));

    private ImageView imageView = new ImageView();

    private String fullPath;
    private boolean isDirectory;

    private boolean isFirstTimeLeaf = true ;
    private boolean isFirstTimeChildren = true ;
    private boolean isLeaf ;    

    public FilePathTreeItem(Path file){
        super(file.toString());
        fullPath = file.toString();

        // test if this is a directory and set the icon
        if (Files.isDirectory(file)){
            isDirectory = true;
            setGraphic(new ImageView(folderClosed));
        }
        else{
            isDirectory = false;

            if (file.endsWith("txt")){
                setGraphic(new ImageView(genericText));
            }
        }

        if(!fullPath.endsWith(File.separator)){
            String value = file.toString();
            int indexOf = value.lastIndexOf(File.separator);

            if (indexOf > 0){
                setValue(value.substring(indexOf + 1));
            }
            else{
                setValue(value);
            }
        }

        this.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
            if (Files.isDirectory(Paths.get(fullPath))) {
                if (isNowExpanded) {
                    imageView.setImage(folderOpened);
                } else {
                    imageView.setImage(folderClosed);
                }
                setGraphic(imageView);
            }
        });


    }

    @Override
    public ObservableList<TreeItem<String>> getChildren() {
        if (isFirstTimeChildren) {
            isFirstTimeChildren = false ;
            super.getChildren().setAll(buildChildren());
        }
        return super.getChildren() ;
    }

    @Override
    public boolean isLeaf() {
        if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false ;
            Path path = Paths.get(fullPath);
            isLeaf = ! Files.isDirectory(path);
        }
        return isLeaf ;
    }

    private ObservableList<TreeItem<String>> buildChildren() {
        Path path = Paths.get(fullPath);
        if (Files.isDirectory(path)) {
            try {
                return Files.list(path).map(FilePathTreeItem::new)
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return FXCollections.observableArrayList();
    }

    public String getFullPath() {
        return fullPath;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}