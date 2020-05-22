public class ConsoleCanvas extends Canvas {
    protected BufferedImage buffer;
    protected int w;
    protected int h;
    protected int[] data;

    public ConsoleCanvas(int w, int h) {
        super();
        this.w = w;
        this.h = h;
    }

    public void initialize() {
        data = new int[h * w];

        // Fill data array with pure solid black
        Arrays.fill(data, 0xff000000);

        // Java's endless black magic to get it working
        DataBufferInt db = new DataBufferInt(data, h * w);
        ColorModel cm = ColorModel.getRGBdefault();
        SampleModel sm = cm.createCompatibleSampleModel(w, h);
        WritableRaster wr = Raster.createWritableRaster(sm, db, null);
        buffer = new BufferedImage(cm, wr, false, null);
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(buffer, 0, 0, null);
    }
}