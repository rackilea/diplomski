import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFrameExample {
  public static void main(String[] args) {
    final JFrame jFrame = new JFrame("This is a test");
    jFrame.setSize(400, 150);
    Container content = jFrame.getContentPane();
    content.setBackground(Color.white);
    content.setLayout(new FlowLayout()); 
    final JTextField jTextField = new JTextField("TestTitle");
    content.add(jTextField);
    final JButton button = new JButton("Change");
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            jFrame.setTitle(jTextField.getText());

        }
    });
    content.add(button);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
  }