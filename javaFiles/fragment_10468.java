public class DoubleBuffer extends Applet {
    int xSize = 900;
    int ySize = 600;

    Image bufferImage;
    Graphics bufferG;
    Timer timer=new Timer(200, ev->repaint());

    @Override
    public void init() {
        this.setSize(xSize, ySize);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        //Double buffering related variables
        bufferImage = this.createImage(xSize, xSize);
        bufferG = bufferImage.getGraphics();
        timer.start();
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        bufferImage = null;
        bufferG = null;
        timer.stop();
    }


    //BUFFERING DONE HERE
    @Override
    public void paint(Graphics g){
        //drawing images to external image first (buffering)
        bufferG.setColor(Color.BLACK);
        bufferG.fillRect(0,0,xSize,ySize);
        bufferG.setColor(Color.WHITE);
        bufferG.drawRect(100, 100, 100, 100);

        //draw the image and call repaint
        g.drawImage(bufferImage, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        // now not clearing the background as we expect paint() to fill the entire area
        this.paint(g);
    }
}