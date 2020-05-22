import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferStrategy;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                PaintPane paintPane = new PaintPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ButtonPane(), BorderLayout.WEST);
                frame.add(paintPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                paintPane.start();
            }
        });
    }

    public class ButtonPane extends JPanel {

        public ButtonPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            for (int index =0; index < 5; index++) {
                add(new JButton(Integer.toString(index)), gbc);
            }
        }

    }

    public class PaintPane extends Canvas {

        private Thread renderThread;
        private AtomicBoolean running = new AtomicBoolean(true);

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void start() {
            if (renderThread != null) {
                return;
            }

            running.set(true);
            renderThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running.get()) {
                        render();
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            });
            renderThread.start();
        }

        public void stop() {
            if (renderThread != null) {
                return;
            }
            running.set(false);
            renderThread.interrupt();
            try {
                renderThread.join();
            } catch (InterruptedException ex) {
            }
            renderThread = null;
        }

        protected void render() {
            BufferStrategy bs = getBufferStrategy();

            if (bs == null) {
                createBufferStrategy(3);
                return;
            }

            do {
                do {
                    Graphics g = bs.getDrawGraphics();
                    // :/
                    //l.setGraphicsObj(g);
                    g.clearRect(0, 0, getWidth(), getHeight());

                    //for (Symbols s : l.getSymbolsArray()) {
                    //  // This is where g should be passed
                    //  s.renderSymbols();
                    //}
                    g.setColor(Color.BLUE);
                    g.fillRect(0, 0, 50, 50); //Just to test & make sure it works
                    g.dispose();
                } while (bs.contentsRestored());
                bs.show();
            } while (bs.contentsLost());
        }

    }

}