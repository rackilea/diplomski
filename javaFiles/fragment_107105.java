file = new File[ELEMENTS];
    ...
    file[0] = new File("C:\\Users\\tony\\Desktop\\MedSalad.png");
    file[1] = new File("C:\\Users\\tony\\Desktop\\JapanesePanNoodles.png");
    file[2] = new File("C:\\Users\\tony\\Desktop\\Spaghetti.png");
    file[3] = new File("C:\\Users\\tony\\Desktop\\PadThai.png");
    file[4] = new File("C:\\Users\\tony\\Desktop\\RamenNoodles.png");
    file[5] = new File("C:\\Users\\tony\\Desktop\\SpaghettiAndMeatBalls.png");
    file[6] = new File("C:\\Users\\tony\\Desktop\\chickenRice.jpg");
    file[7] = new File("C:\\Users\\tony\\Desktop\\thaiFood.jpeg");
    file[8] = new File("C:\\Users\\tony\\Desktop\\vietnamFood.jpg");

    for (int i = 0; i < ELEMENTS; i++) {
        try {
            image[i] = ImageIO.read(file[i]);
            imageIcon[i] = new ImageIcon(image[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }