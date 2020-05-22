public SlideShow() {

    String dir = "C:/.../media";
    try {
        imgs = new Image[3];
        imgs[0] = ImageIO.read(new File(dir + "/image2.png"));
        imgs[1] = ImageIO.read(new File(dir + "/image5.png"));
        imgs[2] = ImageIO.read(new File(dir + "/image12.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }

    setTitle("Slide Show");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(0, 0, 800, 600);

    add(imageComponent, BorderLayout.CENTER);

    JButton nextButton = new JButton(nextAction);
    nextButton.setPreferredSize(new Dimension(100, 30));
    add(nextButton, BorderLayout.SOUTH);

    imageComponent.setIcon(new ImageIcon(imgs[currentImgIndex]));        
}