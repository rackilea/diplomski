class AnimationPanel extends JPanel implements ActionListener{
    /*======Private Instance Variables======*/
    private int timeInterval;
    private Timer animTimer;

    /*======Constructor======*/
    public AnimationPanel(int width, int height){
        timeInterval = 50;
        this.setSize(width, height);
        this.animTimer = new Timer(timeInterval, this);
        animTimer.start();
    }

    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    /*======Private Instance Variables======*/
    public void paintComponent(Graphics g){
        // important to get the component to paint itself & borders etc.
        super.paintComponent(g); 
        BufferedImage bImage = new BufferedImage(this.getWidth(),
            this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bImage.getGraphics();

        bg.setColor(Color.WHITE);
        bg.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());
        bg.dispose();  // Assist the garbage collector!

        g.drawImage(bImage, 0, 0, this);
    }
}