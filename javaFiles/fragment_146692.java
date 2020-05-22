import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalButtonUI;

public class Main {

    public static void main(String[] args) {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name",
                "Stack");
        JButton b = new JButton("press me!");

        b.setBackground(Color.blue);

        b.setContentAreaFilled(false);
        b.setOpaque(true);
        b.setBorderPainted(true);
        b.setUI(new MetalButtonUI());


        JFrame f = new JFrame();

        f.add(b);



        f.setBounds(0, 0, 500, 500);
        JMenuBar m = new JMenuBar();

        m.add(new JMenu("item"));



        f.setJMenuBar(m);
        f.setVisible(true);

        f.setVisible(true);
    }
}