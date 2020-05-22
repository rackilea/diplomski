public BufferedImage LoadTex(String ura) throws IOException {
    BufferedImage res = null;
    URL url = this.getClass().getClassLoader().getResource("tex/" + ura);
    res = ImageIO.read(url);
    return res;
}