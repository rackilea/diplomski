public class Renderer extends JComponent implements ActionListener {
    private int x;        

    public Renderer() {
        Timer timer = new Timer(1000/60, this);
        timer.start();
        x = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paint(g);
        // drawing code
        g.setColor(Color.black);
        g.drawOval(x, 0, 100, 100);
    }

    private void update() {
        this.x++;    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();      
    }