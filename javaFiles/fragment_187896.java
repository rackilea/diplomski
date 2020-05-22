// Supply the program with different icon sizes for different resolutions
ArrayList<Image> icons = new ArrayList<>();
icons.add(ImageIO.read(getClass().getResource("/res/icons/tcc_icon-16x16.png")));
icons.add(ImageIO.read(getClass().getResource("/res/icons/tcc_icon-32x32.png")));
icons.add(ImageIO.read(getClass().getResource("/res/icons/tcc_icon-64x64.png")));
icons.add(ImageIO.read(getClass().getResource("/res/icons/tcc_icon-128x128.png")));
setIconImages(icons);