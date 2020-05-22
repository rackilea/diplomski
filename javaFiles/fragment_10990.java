import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.addFlavorListener(new FlavorListener() {
            @Override
            public void flavorsChanged(FlavorEvent e) {
                System.out.println("Flavor has changed");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                    try {
                        String text = (String) clipboard.getData(DataFlavor.stringFlavor);
                        textDidChangeTo(text);
                    } catch (UnsupportedFlavorException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        Thread t = new Thread(new Runnable() {
            private Integer currentHashcode;
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(this);
                    if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                        try {
                            String text = (String) clipboard.getData(DataFlavor.stringFlavor);
                            if (currentHashcode == null) {
                                currentHashcode = text.hashCode();
                            } else if (currentHashcode != text.hashCode()) {
                                currentHashcode = text.hashCode();
                                textDidChangeTo(text);
                            }
                        } catch (UnsupportedFlavorException | IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        currentHashcode = null;
                    }
                }
            }
        });
        t.start();
    }

    public static void textDidChangeTo(String text) {
        System.out.println("Text did change to: " + text);
    }
}