public class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(20, 40, 10, 10);
        this.setBackground(Color.RED);
    }
}

f.add(new MyPanel());