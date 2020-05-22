import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.*;

public class RotatableImageComponent extends JComponent {

    private static final long serialVersionUID = 1L;
    private Image image;
    private double angle = 0;
    private MyObservable myObservable;

    public RotatableImageComponent() {
        myObservable = new MyObservable();
    }

    public RotatableImageComponent(Image image) {
        this();
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (angle == this.angle) {
            return;
        }
        this.angle = angle;
        double circle = Math.PI * 2;
        while (angle < 0) {
            angle += circle;
        }
        while (angle > circle) {
            angle -= circle;
        }
        if (myObservable != null) {
            myObservable.setChanged();
            myObservable.notifyObservers(this);
        }
        repaint();
    }

    /**
     * In the rotation events sent to the listener(s), the second argument
     * (the value) will be a reference to the RotatableImageComponent. One then
     * should call getAngle() to get the new value.
     * @param o
     */
    public void addRotationListener(Observer o) {
        myObservable.addObserver(o);
    }

    public void removeRotationListener(Observer o) {
        myObservable.deleteObserver(o);
    }

    public void rotateClockwise(double rotation) {
        setAngle(getAngle() + rotation);
    }

    public void rotateCounterClockwise(double rotation) {
        //setAngle(getAngle() - rotation);
        rotateClockwise(-rotation);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            super.paintComponent(g);
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform trans = AffineTransform.getTranslateInstance(getWidth() / 2, getHeight() / 2);
        trans.rotate(angle);
        trans.translate(-image.getWidth(null) / 2, -image.getHeight(null) / 2);
        g2.transform(trans);
        g2.drawImage(image, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        if (image == null) {
            return super.getPreferredSize();
        }
        int wid = image.getWidth(null);
        int ht = image.getHeight(null);
        int dist = (int) Math.ceil(Math.sqrt(wid * wid + ht * ht));
        return new Dimension(dist, dist);
    }

    public static class TimedRotation {

        private RotatableImageComponent comp;
        private long totalTime, startTime;
        private double toRotate, startRotation;
        private int interval;
        public Timer myTimer;
        private myAction mAction;

        public TimedRotation(RotatableImageComponent comp, double toRotate, long totalTime, int interval) {
            //super(interval, new myAction());
            this.comp = comp;
            this.totalTime = totalTime;
            this.toRotate = toRotate;
            this.startRotation = comp.getAngle();
            this.interval = interval;
        }

        public void start() {
            if (mAction == null) {
                mAction = new myAction();
            }
            if (myTimer == null) {
                myTimer = new Timer(interval, new myAction());
                myTimer.setRepeats(true);
            } else {
                myTimer.setDelay(interval);
            }
            myTimer.start();
            startTime = System.currentTimeMillis();
        }

        public void stop() {
            myTimer.stop();
        }

        private class myAction implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                long now = System.currentTimeMillis();
                if (totalTime <= (now - startTime)) {
                    comp.setAngle(startRotation + toRotate);
                    stop();
                    return;
                }
                double percent = (double) (now - startTime) / totalTime;
                double rotation = toRotate * percent;
                comp.setAngle(startRotation + rotation);
            }
        }
    }

    private class MyObservable extends Observable {

        @Override
        protected void setChanged() {
            super.setChanged();
        }
    }

    public static class RotationKeys extends KeyAdapter {

        private RotatableImageComponent comp;
        private double rotationAmt;

        public RotationKeys(RotatableImageComponent comp, double rotationAmt) {
            this.comp = comp;
            this.rotationAmt = rotationAmt;
        }

        public RotationKeys(RotatableImageComponent comp) {
            this(comp, Math.PI / 90);
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                comp.rotateCounterClockwise(rotationAmt);
            } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                comp.rotateClockwise(rotationAmt);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
                    JFileChooser chooser = new JFileChooser();
                    chooser.addChoosableFileFilter(filter);
                    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        File f = chooser.getSelectedFile();
                        BufferedImage im = ImageIO.read(f);
                        final RotatableImageComponent c = new RotatableImageComponent(im);
                        c.addRotationListener(new Observer() {

                            @Override
                            public void update(Observable arg0, Object arg1) {
                                System.out.println("Angle changed: " + ((RotatableImageComponent) arg1).getAngle());
                            }
                        });
                        JPanel controls = new JPanel(new FlowLayout());
                        final JTextField rotation = new JTextField();
                        rotation.setText("30");
                        controls.add(new JLabel("Rotation(degrees)"));
                        controls.add(rotation);
                        final JTextField time = new JTextField();
                        time.setText("1000");
                        time.setColumns(6);
                        rotation.setColumns(7);
                        controls.add(new JLabel("Time(millis)"));
                        controls.add(time);
                        JButton go = new JButton("Go");
                        go.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                TimedRotation tr = new TimedRotation(c,
                                        Double.parseDouble(rotation.getText()) / 180 * Math.PI,
                                        Integer.parseInt(time.getText()), 50);
                                tr.start();
                            }
                        });
                        controls.add(go);
                        RotationKeys keys = new RotationKeys(c);
                        c.addKeyListener(keys);
                        c.setFocusable(true);
                        JFrame jf1 = new JFrame();
                        jf1.getContentPane().add(c);
                        JFrame jf2 = new JFrame();
                        jf2.getContentPane().add(controls);
                        jf1.pack();
                        jf2.pack();
                        jf1.setLocation(100, 100);
                        jf2.setLocation(400, 100);
                        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jf2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        jf1.setVisible(true);
                        jf2.setVisible(true);
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });
    }
}