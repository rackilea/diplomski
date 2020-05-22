public class MyPanel extends JPanel {

    public MyPanel(){
        init();
    }

    public void init(){
        JFrame frame = new JFrame("");
        frame.add(this);
        this.setPreferredSize(new Dimension(100,100));
        this.setBackground(Color.RED);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MyPanel();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 50, 50);
    }
}