import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawTest extends JPanel {

    private Timer resizeTimer;
    private BufferedImage buffer;
    private SwingWorker<BufferedImage, BufferedImage> bufferGenerator;

    public DrawTest() {
        resizeTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buffer = null;

                if (bufferGenerator != null) {
                    bufferGenerator.cancel(true);
                }

                // Create buffer in background
                bufferGenerator = new BufferGeneratorWorker();
                bufferGenerator.execute();
            }
        });
        resizeTimer.setRepeats(false);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        resizeTimer.restart();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (buffer != null) {
            g.drawImage(buffer, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    protected class BufferGeneratorWorker extends SwingWorker<BufferedImage, BufferedImage> {

        @Override
        protected BufferedImage doInBackground() throws Exception {
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            System.out.println("-- Started");
            int i = 0;
            while (i < 100000 && !Thread.currentThread().isInterrupted()) {
                i++;
                g2d.drawLine(0, i, getWidth(), i);
            }
            g2d.dispose();
            System.out.println("-- Completed");
            return img;
        }

        @Override
        protected void done() {
            try {
                buffer = get();
                repaint();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Fill all the squares with Ls");
                DrawTest FillSquare = new DrawTest();
                frame.add(FillSquare);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }
}