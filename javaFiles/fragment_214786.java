public BufferedImage getCustImg(String path){
    BufferedImage img = null;
    String s = get.getProgramPath();
    path = path.trim();
    String s2 = s + "\\Custom\\" + path + ".png";
    try{
        img = ImageIO.read(new File(s2));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return img;
}