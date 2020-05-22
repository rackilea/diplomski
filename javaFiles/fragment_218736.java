public class ShapeGUI extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public ShapeGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        menu.add(file);
        JMenuItem save = new JMenuItem("Save Information");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(save);
        file.add(exit);
        setJMenuBar(menu);

        setLayout(new BorderLayout());

        ShapeListener test = new ShapeListener();
        JButton button = new JButton("Hello");
        test.setBackground(Color.CYAN);
        button.addActionListener(test);
        test.add(button);
        add(test);

        setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                new ShapeGUI();

            }
        });
    }

    public class ShapeListener extends JPanel implements ActionListener {

        Shape s = new Ellipse2D.Float(0, 0, 20, 20);
        Shape a = new Rectangle2D.Float(0, 0, 20, 20);

        private Shape paintMe = a;

        @Override
        public void actionPerformed(ActionEvent e) {
            paintMe = s;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = (getWidth() - paintMe.getBounds().width) / 2;
            int y = (getHeight() - paintMe.getBounds().height) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.translate(x, y);
            g2d.draw(paintMe);
            g2d.dispose();

        }
    }
}