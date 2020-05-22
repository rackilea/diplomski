public class MouseTest extends JComponent {
    public MouseTest () {
        addMouseListener (new MouseAdapter () {
            @Override
            public void mousePressed (MouseEvent e) {
                System.out.println ("Mouse pressed");
                e.consume();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension (320, 240);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor (Color.cyan);
        g.fillRect (getX (), getY (), getWidth (), getHeight ());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Mouse Test");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane ().setLayout (new BorderLayout ());
        frame.getContentPane ().add (new MouseTest (), BorderLayout.CENTER);
        frame.pack ();
        frame.setVisible (true);
    }
}