import java.awt.event.*;
import javax.swing.*;

public class DialogListener {

    public static void main(String[] args) {
        JDialog dialog = new JDialog();
        dialog.setSize(300, 400);
        dialog.setVisible(true);

        KeyListener listener = getKeyListener();

        dialog.addKeyListener(listener);

        JTextArea area = new JTextArea();
        area.addKeyListener(listener);

        dialog.add(area);
    }

    public static KeyListener getKeyListener(){
        return new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        };

    }
}