import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class ZoomOnMouse {

    Robot robot;
    int zoomFactor = 2;
    PointerInfo pi;
    JPanel gui;
    JLabel output;
    Timer t;

    public ZoomOnMouse() throws AWTException {
        robot = new Robot();
        gui = new JPanel(new BorderLayout(2, 2));
        output = new JLabel("Point at something to see it zoomed!");
        gui.add(output, BorderLayout.PAGE_END);
        final int size = 256;
        final BufferedImage bi = new BufferedImage(
                size, size, BufferedImage.TYPE_INT_RGB);
        final JLabel zoomLabel = new JLabel(new ImageIcon(bi));
        gui.add(zoomLabel, BorderLayout.CENTER);

        MouseListener factorListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (zoomFactor == 2) {
                    zoomFactor = 4;
                } else if (zoomFactor == 4) {
                    zoomFactor = 8;
                } else if (zoomFactor == 8) {
                    zoomFactor = 2;
                }
                showInfo();
            }
        };
        zoomLabel.addMouseListener(factorListener);

        ActionListener zoomListener = (ActionEvent e) -> {
            pi = MouseInfo.getPointerInfo();
            Point p = pi.getLocation();
            Rectangle r = new Rectangle(
                    p.x - (size / (2 * zoomFactor)),
                    p.y - (size / (2 * zoomFactor)),
                    (size / zoomFactor),
                    (size / zoomFactor));
            BufferedImage temp = robot.createScreenCapture(r);
            Graphics g = bi.getGraphics();
            g.drawImage(temp, 0, 0, size, size, null);
            g.setColor(new Color(255,0,0,128));
            int x = (size/2)-1;
            int y = (size/2)-1;
            g.drawLine(0,y,size,y);
            g.drawLine(x,0,x,size);
            g.dispose();
            zoomLabel.repaint();
            showInfo();
        };
        t = new Timer(40, zoomListener);
        t.start();
    }

    public void stop() {
        t.stop();
    }

    public Component getGui() {
        return gui;
    }

    public void showInfo() {
        pi = MouseInfo.getPointerInfo();
        output.setText("Zoom: " + zoomFactor + "  Point: " + pi.getLocation());
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                final ZoomOnMouse zm = new ZoomOnMouse();
                final JFrame f = new JFrame("Mouse Zoom");
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.add(zm.getGui());
                f.setResizable(false);
                f.pack();
                f.setLocationByPlatform(true);
                f.setAlwaysOnTop(true);
                f.setVisible(true);

                WindowListener closeListener = new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        zm.stop();
                        f.dispose();
                    }
                };
                f.addWindowListener(closeListener);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}