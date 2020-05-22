import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class mySwing extends JFrame {

    JButton b1, b2;
    String str3="";

    public mySwing() {
        JPanel panel = new JPanel();
        b1 = new JButton("please click me first");
        b2 = new JButton("please click me second");
        final JTextField txt = new JTextField("                            ");
        panel.add(txt);
        Container pane = getContentPane();
        panel.add(b1);
        panel.add(b2);
        pane.add(panel);
        str3 = new String();
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent acv) {
                str3+=" (1)";
                txt.setText(str3);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent acv) {
              str3+=" (2)";
              txt.setText(str3);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new mySwing();
    }
}