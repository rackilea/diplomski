for (int i = 0; i < ELEMENTS; i++) {
        try {
            file[i] = new File("C:\\Users\\tony\\Desktop\\MedSalad.png");
            file[i + 1] = new File("C:\\Users\\tony\\Desktop\\JapanesePanNoodles.png");
            file[i + 2] = new File("C:\\Users\\tony\\Desktop\\Spaghetti.png");
            file[i + 3] = new File("C:\\Users\\tony\\Desktop\\PadThai.png");
            file[i + 4] = new File("C:\\Users\\tony\\Desktop\\RamenNoodles.png");
            file[i + 5] = new File("C:\\Users\\tony\\Desktop\\SpaghettiAndMeatBalls.png");
            file[i + 6] = new File("C:\\Users\\tony\\Desktop\\chickenRice.jpg");
            file[i + 7] = new File("C:\\Users\\tony\\Desktop\\thaiFood.jpeg");
            file[i + 8] = new File("C:\\Users\\tony\\Desktop\\vietnamFood.jpg");

            image[i] = ImageIO.read(file[i]);
            imageIcon[i] = new ImageIcon(image[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }