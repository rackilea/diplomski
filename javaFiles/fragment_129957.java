static {
    try{
        Tile.setMapSprites(ImageIO.read(Tile.class.getResource("res/mas.png")));
    } catch (IOException e){
        e.printStackTrace();
    }
}