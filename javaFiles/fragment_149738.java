try(InputStream is = Files.newInputStream(Paths.get("src/resources/Images/dark.jpg"))){
    ImageView img = new ImageView(new Image(is));
    img.setFitWidth(width);
    img.setFitHeight(height);
    root.getChildren().add(img);
}catch (IOException e) {
    System.out.println("Could not load");
}