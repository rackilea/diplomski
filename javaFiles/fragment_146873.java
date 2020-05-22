package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Handybastler extends JFrame implements ActionListener {

String     Status   = "Verbindung getrennt";
String     Wahl = "";
JFrame     frame    = new JFrame("handy");
JTextField feld     = new JTextField(21);

JButton    button1  = new JButton("Wahl");
JButton    button2  = new JButton("Leer");
JButton    button3  = new JButton("Abbr.");
JButton    button4  = new JButton("1");
JButton    button5  = new JButton("2");
JButton    button6  = new JButton("3");
JButton    button7  = new JButton("4");
JButton    button8  = new JButton("5");
JButton    button9  = new JButton("6");
JButton    button10 = new JButton("7");
JButton    button11 = new JButton("8");
JButton    button12 = new JButton("9");
JButton    button13 = new JButton("Leer");
JButton    button14 = new JButton("0");
JButton    button15 = new JButton("Leer");

public Handybastler() {
    JLabel label = new JLabel(Status);
    frame.setSize(250, 350);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(5, 3, 5, 5));

    panel.add(feld);
    panel2.add(button1);
    panel2.add(button2);
    panel2.add(button3);
    panel2.add(button4);
    panel2.add(button5);
    panel2.add(button6);
    panel2.add(button7);
    panel2.add(button8);
    panel2.add(button9);
    panel2.add(button10);
    panel2.add(button11);
    panel2.add(button12);
    panel2.add(button13);
    panel2.add(button14);
    panel2.add(button15);

    button15.setVisible(false);
    button13.setVisible(false);
    button2.setVisible(false);
    frame.add(label, BorderLayout.SOUTH);
    frame.add(panel, BorderLayout.NORTH);
    frame.add(panel2);
    frame.setVisible(true);

    Listener();
}

public void Listener() {
    button1.addActionListener(this);
    button3.addActionListener(this);
    button4.addActionListener(this);
    button5.addActionListener(this);
    button6.addActionListener(this);
    button7.addActionListener(this);
    button8.addActionListener(this);
    button9.addActionListener(this);
    button10.addActionListener(this);
    button11.addActionListener(this);
    button12.addActionListener(this);
    button14.addActionListener(this);
}

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == this.button4) {
        String A = "1";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button5) {
        String A = "2";
        Wahl = Wahl + A;
        waehle(Wahl);
    }

    else if (ae.getSource() == this.button6) {
        String A = "3";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button7) {
        String A = "4";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button8) {
        String A = "5";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button9) {
        String A = "6";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button10) {
        String A = "7";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button11) {
        String A = "8";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button12) {
        String A = "9";
        Wahl = Wahl + A;
        waehle(Wahl);
    } else if (ae.getSource() == this.button14) {
        String A = "0";
        Wahl = Wahl + A;
        waehle(Wahl);
    }

}

public void waehle(String Wahl) {
    feld.setText(Wahl);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new Handybastler();
        }
    });
}
}