try {
    Image image = ImageIO.read(aa.class.getResource("/TestImage.png"));
    setIconImage(image);
} (IOException e) {
   // handle exception
}