class TetrisMenu extends JPanel {

    private static final long   serialVersionUID    = 1L;
    private Thread              thread;
    private BufferedImage       titletop, titlebottom;

    public TetrisMenu() {
        super();
        loadImages();
        repaint();
    }

    private void loadImages() {
        try {
            titletop = ImageIO.read( new File( "tetrispic.png" ) );
            titlebottom = ImageIO.read( new File( "titlebottom.png" ) );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void paint( Graphics g ) {
        super.paint( g );
        if ( titletop != null )
            g.drawImage( titletop, 0, 0, 640, 440, null );
        if ( titlebottom != null )
            g.drawImage( titlebottom, 0, 440, null );
    }
}