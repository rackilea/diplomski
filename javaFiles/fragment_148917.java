package SSCCE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideBYSide extends JFrame{

    public static void main(String[] args) {
        new SideBYSide();
    }

    public SideBYSide(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 75);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        panelOne.add(new JLabel("1"));
        panelTwo.add(new JLabel("2"));

        container.setLayout(new GridLayout(1,2));
        container.add(panelOne);
        container.add(panelTwo);

        this.add(container);
    }

 }