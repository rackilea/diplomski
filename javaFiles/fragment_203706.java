public ImageIcon randomizer() {

    try {
        purpleBlock.setImage(ImageIO.read(new File("purpleBlock.png")));
        redBlock.setImage(ImageIO.read(new File("redBlock.png")));
        blueBlock.setImage(ImageIO.read(new File("blueBlock.png")));
        greenBlock.setImage(ImageIO.read(new File("greenBlock.png")));
    } catch (IOException e) {
        e.printStackTrace();
    }   

    Random r = new Random();
    int rNum = r.nextInt(4);

    if(rNum==0) {
        return purpleBlock;
    } else if(rNum==1) {
        return redBlock;
    } else if(rNum==2) {
        return greenBlock;
    } else {
        return blueBlock;
    }
}