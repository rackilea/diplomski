import java.awt.*;
import javax.swing.*;

public class TextFieldHighlight extends JTextField {

    static JTextField ftf;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                ftf = new JTextField("Highlight");
                ftf.setEditable(false);
                f.add(ftf, BorderLayout.CENTER);
                f.pack();
                f.setVisible(true);
                Thread thread = new Thread(new Runnable() {

                    boolean focused = false;

                    @Override
                    public void run() {
                        while (true) {
                            if (mouseIsOverDisplayPanel()) {
                                if (ftf.hasFocus() && focused == false) {
                                    ftf.selectAll();
                                    focused = true;
                                } else if (!ftf.hasFocus()) {
                                    focused = false;
                                }
                            }
                        }
                    }
                });
                thread.start();
            }
        });

    }

    private static boolean mouseIsOverDisplayPanel() {

        if (MouseInfo.getPointerInfo().getLocation().x >= ftf.getLocationOnScreen().x
                && MouseInfo.getPointerInfo().getLocation().x <= ftf.getLocationOnScreen().x + ftf.getWidth()
                && MouseInfo.getPointerInfo().getLocation().y >= ftf.getLocationOnScreen().y
                && MouseInfo.getPointerInfo().getLocation().y <= ftf.getLocationOnScreen().y + ftf.getHeight()) {

            return true;

        } else {

            return false;

        }
    }
}