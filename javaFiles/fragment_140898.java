InputStream file = new FileInputStream(getClass().getResource("/edit.png").getPath());
    Image image = new Image(file);
    ImageView icon = new ImageView(image);


    File f = new File(getClass().getResource("/zelda.mp4").toURI());