class TileButton extends JButton {
    private int id;
    private TileSet ts = new TileSet("Content/Graphics/tileSets/12x12x3 - tileSet.png", 12, 12, 3);
    private int size = 50;
    public TileButton(int id, TileSet tileSet) {
        super();
        this.ts = tileSet;
        this.id = id;
        loadImage(id);
    }