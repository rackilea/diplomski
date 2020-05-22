class DrawPanel extends JPanel {
    private final BufferedImage img;
    private int w;
    private int h;

    DrawPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.img = createImage("D:\\pict1.jpg");
    }

    private BufferedImage createImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
            double scale = 0.5;
            this.w = (int) (scale * img.getWidth(this));
            this.h = (int) (scale * img.getHeight(this));
        } catch (IOException e) {
            System.err.println("Could not read file with path " + path);
            e.printStackTrace();
        }
        return img;
    }

    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        int x= Multi_Paint.x;
        int y= Multi_Paint.y;

        // img could be null
        if(this.img != null) {
            g.drawImage(img, x, y, w, h, this);
        }

        g.fillOval(x, y, 30, 30);
    }  
}