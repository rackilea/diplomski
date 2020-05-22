@FXML private TreeView<File> filesTree;

@Override
public void initialize(URL url, ResourceBundle rb) {
    File currentDir = new File("src/xslt"); // current directory
    findFiles(currentDir,null);
}

private void findFiles(File dir, TreeItem<File> parent) {
    TreeItem<File> root = new TreeItem<>(dir);
    root.setExpanded(true);
    try {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("directory:" + file.getCanonicalPath());
                findFiles(file,root);
            } else {
                System.out.println("     file:" + file.getCanonicalPath());
                root.getChildren().add(new TreeItem<>(file));
            }

        }
        if(parent==null){
            filesTree.setRoot(root);
        } else {
            parent.getChildren().add(root);
        }
    } catch (IOException e) {
       e.printStackTrace();
    }
}