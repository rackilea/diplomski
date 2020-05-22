public class ImageScreenShot extends JFrame implements MouseListener, MouseMotionListener {

@Override
public Dimension getPreferredSize() {
    return super.getPreferredSize();
}

private static Thread screenShotThread;

public static Thread getScreenShotThread() {
    return screenShotThread;
}

public static void setScreenShotThread(Thread screenShot) {
    ImageScreenShot.screenShotThread = screenShot;
}

private int drag_status = 0, c1, c2, c3, c4;

public int getC1() {
    return c1;
}

public int getC2() {
    return c2;
}

public int getC3() {
    return c3;
}

public int getC4() {
    return c4;
}

class AdditionalPanel extends JLabel {
    private BufferedImage img;

    public BufferedImage getImg() {
        return img;
    }

    public AdditionalPanel(BufferedImage img) {
        this.img = img;
        setPreferredSize(new Dimension(2560, 1600));
        getPreferredSize();
        setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
        System.out.println("Additional panel class paint method was invoked");
    }
}

public void cut() {
    AdditionalPanel apanel = new AdditionalPanel(PicChanges.getNewImage());
    JScrollPane scrollPane = new JScrollPane(apanel);
    scrollPane.addMouseMotionListener(this);
    scrollPane.addMouseListener(this);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    setPreferredSize(new Dimension(2560, 1600));
    getPreferredSize();
    pack();
    setVisible(true);
}

private void draggedScreen() throws Exception {
    int w = c1 - c3;
    int h = c2 - c4;
    w = w * -1;
    h = h * -1;
    Robot robot = new Robot();
    BufferedImage img = robot.createScreenCapture(new Rectangle(c1, c2, w, h));
    File save_path = new File("screen1.jpg");
    ImageIO.write(img, "JPG", save_path);
    GraphicalUserInterface.getLabelIcon().setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH)));
    JOptionPane.showConfirmDialog(this, "Would you like to save your cropped Pic?");
    System.out.println("Cropped image saved successfully.");
}

@Override
public void mouseClicked(MouseEvent arg0) {
}

@Override
public void mouseEntered(MouseEvent arg0) {
}

@Override
public void mouseExited(MouseEvent arg0) {
}

@Override
public void mousePressed(MouseEvent arg0) {
    repaint();
    c1 = arg0.getXOnScreen();
    c2 = arg0.getYOnScreen();
    System.out.println("pressed");
}

@Override
public void mouseReleased(MouseEvent arg0) {
    repaint();
    if (drag_status == 1) {
        c3 = arg0.getXOnScreen();
        c4 = arg0.getYOnScreen();
        try {
            repaint();
            draggedScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Override
public void mouseDragged(MouseEvent arg0) {
    repaint();
    drag_status = 1;
    c3 = arg0.getXOnScreen();
    c4 = arg0.getYOnScreen();
}

@Override
public void mouseMoved(MouseEvent arg0) {
}

@Override
public void paint(Graphics g) {
    super.paint(g);
    int w = c1 - c3;
    int h = c2 - c4;
    w = w * -1;
    h = h * -1;
    if (w < 0)
        w = w * -1;
    g.setColor(Color.RED);
    g.drawRect(c1, c2, w, h);
    System.out.println("Paint component was invoked in imagescreenshot class");
}