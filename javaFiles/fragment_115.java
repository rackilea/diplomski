public class TestGui extends JFrame {
    public TestGui() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setLayout(new BorderLayout());
        createMenu(this.getContentPane());
        createPanel(this.getContentPane());
        this.pack();
        this.setPreferredSize(this.getSize());
        this.setLocationRelativeTo(null);

    }

private void createMenu(Container pane) {


    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Datei");
    menuBar.add(menu);
    JMenuItem menuItemClose = new JMenuItem("Schließen");
    JMenuItem menuItemEdit = new JMenuItem("Bearbeiten");
    JMenuItem menuItemUndo = new JMenuItem("Rückgängig");

    menuItemEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    menuItemEdit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    menuItemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
    menuItemClose.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    JMenuItem menuItemAdd = new JMenuItem("Einfügen");
    menuItemAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    menuItemAdd.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    });

    menuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    menuItemUndo.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    });
    menu.add(menuItemAdd);
    menu.add(menuItemEdit);
    menu.add(menuItemUndo);
    menu.add(menuItemClose);
    menuBar.setMinimumSize(new Dimension(100, 21));


    pane.add(menuBar, BorderLayout.PAGE_START);
}
private void createPanel(Container contentPane) {
    JPanel g = new JPanel();
    g.setPreferredSize(new Dimension(500, 300));

    image = new BufferedImage(800, 400, BufferedImage.TYPE_INT_RGB);

    // Set max size of the panel, so that is matches the max size of the
    // image.
    g.setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));

    clear();
    add(g);
}

private final static Color BACKGROUND_COL = Color.DARK_GRAY;

private BufferedImage image;

public void drawLine(Color color, int x1, int y1, int x2, int y2) {

    Graphics g = image.getGraphics();

    g.setColor(color);

    g.drawLine(x1, y1, x2, y2);
}

public void clear() {

    Graphics g = image.getGraphics();

    g.setColor(BACKGROUND_COL);

    g.fillRect(0, 0, image.getWidth(), image.getHeight());
}

@Override
public void paint(Graphics g) {

    // render the image on the panel.
    g.drawImage(image, 0, 0, null);
}

}