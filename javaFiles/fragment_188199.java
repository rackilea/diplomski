import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox {
    private static final ActionListener Event = null;
    JComboBox combo1;
    JComboBox combo2;
    JComboBox combo3;
    JTextField txt;
    Button boton;

    public static void main(String[] args) {
        ComboBox b = new ComboBox();
    }

    public ComboBox() {
        String course1[] = { "India", "Germany", "America", "Russia" };
        String course2[] = { "India", "Germany", "America", "Russia" };
        String course3[] = { "India", "Germany", "America", "Russia" };
        JFrame frame = new JFrame("Creating a JComboBox Component");
        JPanel panel = new JPanel();
        combo1 = new JComboBox(course1);
        combo2 = new JComboBox(course2);
        combo3 = new JComboBox(course3);
        txt = new JTextField(30);
        boton = new Button( "Boton");
        panel.add(combo1);
        panel.add(combo2);
        panel.add(combo3);
        panel.add(txt);
        panel.add(boton);
        frame.add(panel);

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    String str1 = (String) combo1.getSelectedItem();
                    String str2 = (String) combo2.getSelectedItem();
                    String str3 = (String) combo3.getSelectedItem();
                    txt.setText(str1+str2+str3);

            }
        });
        combo1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}