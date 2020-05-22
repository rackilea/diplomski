import java.awt.Component;
import java.awt.Container;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * <code>IncreaseFileChooserFont</code>.
 */
public class IncreaseFileChooserFont {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFileChooser chooser = new JFileChooser();
                setFileChooserFont(chooser.getComponents());
                chooser.showOpenDialog(null);
                System.exit(0);
            }
        });
    }

    public static void setFileChooserFont(Component[] comp) {
        for (int x = 0; x < comp.length; x++) {
            // System.out.println( comp[x].toString() ); // Trying to know the type of each element in the JFileChooser.
            if (comp[x] instanceof Container)
                setFileChooserFont(((Container) comp[x]).getComponents());

            try {
                if (comp[x] instanceof JList || comp[x] instanceof JTable)
                    comp[x].setFont(comp[x].getFont().deriveFont(comp[x].getFont().getSize() * 2f));
            } catch (Exception e) {
            } // do nothing
        }
    }
}