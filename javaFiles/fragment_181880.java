import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Example extends JFrame {

    public Example() {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2,0));

        JTextArea jTextArea1 = new JTextArea();
        jTextArea1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTextArea1.setText("");
                    System.out.println("carat: "
                            + jTextArea1.getCaretPosition());
                    System.out.println("length: "
                            + jTextArea1.getText().length());
                    jTextArea1.setCaretPosition(0);
                    // jTextArea2.moveCaretPosition(0);
                    System.out.println("line: " + jTextArea1.getLineCount());
                }
            }
        });
        jTextArea1.setBorder(new LineBorder(Color.BLACK));
        jTextArea1.setText("This TextArea will not work like you want it to");

        JTextArea jTextArea2 = new JTextArea();
        jTextArea2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTextArea2.setText("");
                    System.out.println("carat: "
                            + jTextArea2.getCaretPosition());
                    System.out.println("length: "
                            + jTextArea2.getText().length());
                    jTextArea2.setCaretPosition(0);
                    // jTextArea2.moveCaretPosition(0);
                    System.out.println("line: " + jTextArea2.getLineCount());
                }
            }
        });
        jTextArea2.setBorder(new LineBorder(Color.BLACK));
        jTextArea2.setText("This TextArea WILL");

        frame.add(jTextArea1);
        frame.add(jTextArea2);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Example();
    }
}