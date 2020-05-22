@SuppressWarnings("serial")
class TestPanel extends JPanel {
    int w, h;
    private static int WIDTH = 700;
    private static int HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = Color.white;
    private BufferedImage bImg;
    private Color color = Color.black;

    public TestPanel() {
        bImg =  new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g = bImg.getGraphics();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Timer myTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(w!=0&&h!=0){
                    if(WIDTH!=w&&HEIGHT!=h){
                        WIDTH = w; HEIGHT = h;
                        System.out.println("create");
                        bImg =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
                    }
                }
                repaint();
            }
        });
        myTimer.setInitialDelay(0);
        myTimer.setRepeats(true);
        myTimer.setCoalesce(true);
        myTimer.start();
        g.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        w = getWidth();
        h = getHeight();
//      System.out.println("w, h are: "+w+", "+h);
        long startTime = System.currentTimeMillis();
        long endDrawImageTime = System.currentTimeMillis();
//        Graphics2D g2 = (Graphics2D) g;
        drawRandomScreen(bImg);
        g.drawImage(bImg, 0, 0, null);
        long endDrawScreenTime = System.currentTimeMillis();
        long stopTime = System.currentTimeMillis();
        long drawImageTime = endDrawImageTime - startTime;
        long drawScreenTime = endDrawScreenTime - endDrawImageTime;
        long elapsedTime = stopTime - startTime;
        System.out.println(drawImageTime+", "+drawScreenTime+", "+elapsedTime); 
    }

    private void drawRandomScreen(BufferedImage image) {

        final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();

        long startTime = System.currentTimeMillis();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
        Random r = new Random();
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                    color = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
                    int pos = j*width+i;
                    pixels[pos] = color.hashCode();

            }
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("time "+(stopTime-startTime));
    }
}