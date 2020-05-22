String bgImg = "root/resources/dark.jpg";
    URL bgImgPath = Main.class.getClassLoader().getResource(bgImg);
    ImageView img = new ImageView(new Image(bgImgPath.toExternalForm()));
    img.setFitWidth(width);
    img.setFitHeight(height);
    root.getChildren().add(img);