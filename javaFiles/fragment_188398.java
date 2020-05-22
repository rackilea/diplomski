JFrame container = new JFrame("Space Invaders");
JLabel label = new JLabel(new ImageIcon(ImageIO.read(...)));
label.setLayout(new BorderLayout());
container.setContentPane(label);

// Resolution
// There are simply so many different ways to achieve this
// that are better it's not funny
//JPanel panel = (JPanel) container.getContentPane();
//panel.setPreferredSize(new Dimension(800, 600));
//panel.setLayout(null);

// Canvas Size
//setBounds(0, 0, 800, 600);
//panel.add(this);

// Window Visible
container.pack();
container.setResizable(false);
container.setVisible(true);

container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Pointless
//container.addWindowListener(new WindowAdapter() {
//    public void windowClosing(WindowEvent e) {
//          System.exit(0);
//      }
//});