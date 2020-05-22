package a.b.c;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myJPanel6 extends JPanel implements ActionListener {
    JButton b1, b2;
    student st1;
    String s1;

    public myJPanel6() {
        setLayout(new GridLayout(1, 1));

        st1 = new student("Michael", "Robinson", 20);
        b1 = new JButton(st1.getName());
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton(st1.WhatIsUp());
        b2.addActionListener(this);
        add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            s1 = st1.getName();
            b2.setText(s1);

        }
    }

    public static void main(String[] args) {
        JFrame frm=new JFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJPanel6 pnl=new myJPanel6();
        frm.add(pnl);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}