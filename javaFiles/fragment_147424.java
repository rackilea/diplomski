package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author floz
 */
public class Test {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame mainFrame = new JFrame("test");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final JTextPane field = new JTextPane();
                field.setText("qds qljsd qsld qlskd qlkds fqlk sdkf qlskdfqlk sdlf qsld ql sdf qlskd fqks lqksjd f");

                mainFrame.getContentPane().setLayout(new BorderLayout());
                mainFrame.getContentPane().add(field,BorderLayout.CENTER);
                mainFrame.setSize(200,200);
                mainFrame.setVisible(true);
            }
        });
    }
}