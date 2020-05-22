import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClipboardMonitor {

    public static void main(String[] args) {
        new ClipboardMonitor();
    }

    public ClipboardMonitor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea textArea;

        public TestPane() {
            textArea = new JTextArea(10, 10);
            setLayout(new BorderLayout());
            add(new JScrollPane(textArea));
            Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {
                @Override
                public void flavorsChanged(FlavorEvent e) {
                    setText(getClipboardContents());
                }
            });
            Thread t = new Thread(new ContentsMonitor());
            t.setDaemon(true);
            t.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected String getClipboardContents() {
            String text = null;
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    Transferable contents = clipboard.getContents(TestPane.this);
                    text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            return text;
        }

        protected void setText(final String text) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    textArea.setText(text);
                }
            });
        }

        public class ContentsMonitor implements Runnable {

            @Override
            public void run() {
                String previous = getClipboardContents();
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    String text = getClipboardContents();
                    if (text != null && !text.equals(previous)) {
                        setText(text);
                        previous = text;
                    }
                }
            }
        }
    }
}