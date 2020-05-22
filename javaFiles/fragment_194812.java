public class Main {
    private JFrame frame = new JFrame();
    private JLayeredPane lpane = new JLayeredPane();
    private JPanel panel1 = new MyPanel("C:\\Users\\PATH\\Pictures\\Image.png");
    private JPanel panel2 = new JPanel();
    public Main()
    {
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setLayout(new BorderLayout());
        frame.add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 600, 400);
        panel1.setBounds(0, 0, 600, 400);
        panel1.setOpaque(true);
//      panel2.add(linedraw1);
        panel2.setBounds(200, 100, 100, 100);
        panel2.setOpaque(false);
        lpane.add(panel1, new Integer(0), 0);
        lpane.add(panel2, new Integer(1), 0);
        frame.pack();
        frame.setVisible(true);
    }

    // This is your custom panel
    class MyPanel extends JPanel {
        private static final long serialVersionUID = -4559408638276405147L;
        private String imageFile;

        public MyPanel(String imageFile) {
            this.imageFile = imageFile;
        }
        @Override
        protected void paintComponent(Graphics g) {
            // Add your image here
            Image img = new ImageIcon(imageFile).getImage();
            g.drawImage(img, 0, 0, this);

            //Add your lines here
            g.setColor(Color.black);
            g.drawLine(0, 0, g.getClipBounds().width, g.getClipBounds().height);
            g.setColor(Color.red);
            g.drawLine(0, g.getClipBounds().height, g.getClipBounds().width, 0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

}