FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Open Image File");
fileChooser.getExtensionFilters().addAll(
     new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
);
File selectedFile = fileChooser.showOpenDialog(mainStage);