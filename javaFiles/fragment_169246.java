import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.StrokeBorder;

public class ListTryout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UIManager.put("List.focusCellHighlightBorder", BorderFactory.createDashedBorder(Color.GRAY));
                final JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new JScrollPane(new JList<String>(new String[] {"one", "two", "three"})));
                f.pack();
                f.setVisible(true);
            }
        });
    }
}