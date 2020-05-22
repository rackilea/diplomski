class TileButton extends JButton {
    private int id;
    private final TileSet ts;
    private int size = 50;
    public TileButton(int id, TileSet tileSet) {
        super();
        this.ts = tileSet;
        this.id = id;
        loadImage(id);
    }