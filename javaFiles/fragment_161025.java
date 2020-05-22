file = fileChooser.showOpenDialog(stage);

if (file == null) {
    file = new File("path/to/default/file")
}

image = new Image(file.getAbsoluteFile().toURI().toString(),imageView.getFitWidth(),imageView.getFitHeight(),true,true);
imageView.setImage(image);
imageView.setPreserveRatio(true);

fis = new FileInputStream(file);