String prefix = "D:\\TestFolder\\";
    String[] ids = { "Capture"};
    String ext = ".png";
    Image[] images = new Image[ids.length];
    for(int i = 0; i < images.length; i++) {
        String path = prefix + ids[i] + ext;
        images[i] = ImageIO.read(new File(path));
    }