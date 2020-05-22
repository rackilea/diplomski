try {
    wallpaper = ImageIO.read(getClass().getResource("images/wallpaper.jpg"));

    for (int i = 0; i < 30; i++) {

        teamsImg[i] = ImageIO.read(getClass().getResource("images/img.png"));

    }
} catch (IOException iOException) {
    System.err.println("Bad things happened");
    iOException.printStackTrace();
}