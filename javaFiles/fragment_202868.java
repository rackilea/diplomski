@FXML
public void initialize() {
    refresh();
}

public void refresh() {
   if (!(miniFilterPath == null | miniFilterPath.trim().equals("")))
       miniFilePath.setText(miniFilterPath);
}