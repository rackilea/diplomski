public class TestPaint {

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL URL = TestPaint.class.getResource(path);
        if (URL != null) {
            return (new ImageIcon(URL));
        } else {
            System.err.println("Can't open '" + path + "'\n");
            return (null);
        }
    }
    private JFrame win;
    private JMenuBar menubar;
    private JPanel panel;
    private Container con;
    private JPanel drawa;
    private JButton b1;
    private JButton b2;

    public TestPaint() {

        win = new JFrame("Fortune Cookie");
        win.setSize(640, 480);
        win.setLocation(100, 100);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setDefaultLookAndFeelDecorated(true);

        menubar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menubar.add(menu);
        JMenuItem menuitem = new JMenuItem("Quit");
        menuitem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Menuitem1\n");
                win.dispose();
            }
        });
        menu.add(menuitem);
        menu.addSeparator();
        JMenuItem menuitem2 = new JMenuItem("About");
        menuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Menuitem2\n");
            }
        });
        menu.add(menuitem2);
        win.setJMenuBar(menubar);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Color backcol = new Color(90, 0, 0);
        panel.setBackground(backcol);
        con = win.getContentPane();
        con.add(panel, BorderLayout.EAST);
        drawa = new JPanel();
        drawa.setPreferredSize(new Dimension(462, 0));
        drawa.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        drawa.setBackground(Color.blue);
        win.setBackground(Color.magenta);
        JPanel panel2 = new JPanel();
        panel2.setBackground(backcol);
        panel2.setPreferredSize(new Dimension(400, 80));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        try {
            InputStream is = new FileInputStream("deng_th_.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            Color textcol = new Color(255, 255, 0);
            JLabel nulltext = new JLabel("    ");
            nulltext.setFont(font.deriveFont(38f));
            panel2.add(nulltext);
            JLabel titletext = new JLabel("        Fortune Cookie:");
            titletext.setFont(font.deriveFont(24f));
            titletext.setForeground(textcol);
            panel2.add(titletext);
        } catch (IOException ex) {
            System.out.println("Font File Error:");
        } catch (FontFormatException ex) {
            System.out.println("Font Error:");
        }
        con.add(panel2, BorderLayout.NORTH);
        JPanel panel3 = new JPanel();
        panel3.setBackground(backcol);
        panel3.setPreferredSize(new Dimension(400, 10));
        con.add(panel3, BorderLayout.SOUTH);
        JPanel panel4 = new JPanel();
        panel4.setBackground(backcol);
        panel4.setPreferredSize(new Dimension(10, 400));
        con.add(panel4, BorderLayout.WEST);
        b1 = new JButton("Another");
        b1.setToolTipText("Get another fortune cookie");
        b1.setPreferredSize(new Dimension(150, 48));
        b1.setMinimumSize(new Dimension(150, 48));
        b1.setMaximumSize(new Dimension(150, 48));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Button1\n");
            }
        });
        ImageIcon b2i = createImageIcon("rand.jpg");
        b2 = new JButton("Non-Random", b2i);
        b2.setToolTipText("Toggle random selection");
        b2.setPreferredSize(new Dimension(150, 48));
        b2.setMinimumSize(new Dimension(150, 48));
        b2.setMaximumSize(new Dimension(150, 48));
        b2.addActionListener(new ActionListener() {
            private int randc;
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Button2\n");
                randc = 1 - randc;
                if (randc == 0) {
                    b2.setText("Random");
                } else {
                    b2.setText("Non-Random");
                }
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(b1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(b2);
//        Canvas can = new Canvas();
        Color cancol = new Color(220, 220, 220);
//        can.setBackground(cancol);
//        drawa.add(can);
        con.add(drawa, BorderLayout.CENTER);
        con.add(new CustomPaint(), BorderLayout.NORTH);
        win.setIconImage(new ImageIcon("rand.png").getImage());
        win.setVisible(true);
    }

    public static void main(String[] args) {
        int i, numcook = 0, x, y;
        int[] cookiepos = new int[500];
        Random ranGen2 = new Random();
        long seed;
        File fp = new File("cookie.idx");

        new TestPaint();

    }

    public class CustomPaint extends JPanel {

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(100, 100);

        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLUE);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setColor(Color.WHITE);

            FontMetrics fontMetrics = g2.getFontMetrics();

            g2.drawString("This is a test", 20, fontMetrics.getAscent());
            g2.drawLine(10, 10, 290, 290);
        }
    }
}