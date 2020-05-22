BufferedImage drinkImage = null;
    try {
        drinkImage= ImageIO.read(new File("src/fotos/trinidad.jpg"));
    } catch (IOException e) {
        // TODO
        e.printStackTrace();
    }
    ImageIcon image = new ImageIcon(drinkImage);

    // Put image in your JPanel