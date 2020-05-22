public class TestPane extends JPanel {

    public TestPane() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // The background is painted for us, so we don't need to
        // You shouldn't be relying on "magic" numbers anyway
        //g.setColor(Color.BLACK);
        //g.fillRect(0,0,500,600);

        g.setColor(Color.RED);
        g.fillOval(20,30,50,50);      
        // Never, ever, call repaint in here
        // bad things happen, fairies lose wings
        // black holes suck small children to oblivion
        // Fire Fly gets cancelled  
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 600);
    }
}