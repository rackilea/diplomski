/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.util.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author shreyansh.jogi
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JavaApplication2 extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, add, sub, div, mult, equalto, exit, point, reset;
    JTextField txtfld;
    String s = "", ope = "";
    int flag = 0;
    double total1;
    double first, second;

    Double toDouble(String a) {
        double i = Double.parseDouble(a);
        return i;
    }

    void total(double first, double second, String ope) {
        String total;

        if (ope.equalsIgnoreCase("+")) {

            total1 = first + second;
            // System.out.println(first+"\n"+second+"\n"+sum);
            total = Double.toString(total1);
            txtfld.setText(total);
        } else if (ope.equalsIgnoreCase("-")) {
            total1 = first - second;
            total = Double.toString(total1);
            txtfld.setText(total);
        } else if (ope.equalsIgnoreCase("*")) {
            total1 = first * second;
            total = Double.toString(total1);
            txtfld.setText(total);
        } else if (ope.equalsIgnoreCase("/")) {

            total1 = first / second;
            total = Double.toString(total1);
            txtfld.setText(total);
        }
        clearfields();
    }

    public JavaApplication2() {
        Container content = getContentPane();
        content.setLayout(new FlowLayout());
        JLabel jl = new JLabel("          Calculator                ");
        txtfld = new JTextField(15);
        num1 = new JButton(" 1 ");
        num2 = new JButton(" 2 ");
        num3 = new JButton(" 3 ");
        num4 = new JButton(" 4 ");
        num5 = new JButton(" 5 ");
        num6 = new JButton(" 6 ");
        num7 = new JButton(" 7 ");
        num8 = new JButton(" 8 ");
        num9 = new JButton(" 9 ");
        num0 = new JButton(" 0 ");
        add = new JButton(" + ");
        sub = new JButton("  -  ");
        div = new JButton("  / ");
        mult = new JButton(" *  ");
        equalto = new JButton(" = ");
        exit = new JButton("    Exit     ");
        point = new JButton("  . ");
        reset = new JButton("C");
        reset.setBackground(Color.RED);
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);
        num0.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        equalto.addActionListener(this);
        exit.addActionListener(this);
        point.addActionListener(this);
        reset.addActionListener(this);
        content.add(jl);
        content.add(txtfld);
        content.add(num1);
        content.add(num2);
        content.add(num3);
        content.add(add);
        content.add(num4);
        content.add(num5);
        content.add(num6);
        content.add(sub);
        content.add(num7);
        content.add(num8);
        content.add(num9);
        content.add(div);
        content.add(num0);
        content.add(point);


        content.add(mult);
        content.add(equalto);
        content.add(reset);
        content.add(exit);
    }

    public static void main(String arg[]) {
        JavaApplication2 jf = new JavaApplication2();
        jf.setSize(230, 250);
        jf.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o == num1) {
            txtfld.setText(s.concat("1"));
            s = txtfld.getText();
        } else if (o == num2) {
            txtfld.setText(s.concat("2"));
            s = txtfld.getText();
        } else if (o == num3) {
            txtfld.setText(s.concat("3"));
            s = txtfld.getText();
        } else if (o == num4) {
            txtfld.setText(s.concat("4"));
            s = txtfld.getText();
        } else if (o == num5) {
            txtfld.setText(s.concat("5"));
            s = txtfld.getText();
        } else if (o == num6) {
            txtfld.setText(s.concat("6"));
            s = txtfld.getText();
        } else if (o == num7) {
            txtfld.setText(s.concat("7"));
            s = txtfld.getText();
        } else if (o == num8) {
            txtfld.setText(s.concat("8"));
            s = txtfld.getText();
        } else if (o == num9) {
            txtfld.setText(s.concat("9"));
            s = txtfld.getText();
        } else if (o == num0) {
            txtfld.setText(s.concat("0"));
            s = txtfld.getText();
        } else if (o == add) {

            txtfld.setText("");
            first = toDouble(s);
            System.out.println(first);
            s = "";
            ope = "+";
        } else if (o == sub) {
            txtfld.setText("");
            first = toDouble(s);
            s = "";
            ope = "-";
        } else if (o == mult) {

            txtfld.setText("");
            first = toDouble(s);
            s = "";
            ope = "*";
        } else if (o == div) {
            txtfld.setText("");
            first = toDouble(s);
            s = "";
            ope = "/";
        } else if (o == equalto) {
            if (flag == 0) {
                second = toDouble(s);
                total(first, second, ope);
                flag = 1;
            } else if (flag == 1) {
                second = toDouble(s);
                total(first, second, ope);
            }
            System.out.println(first);
        } else if (o == exit) {
            System.exit(0);
        } else if (o == point) {
            txtfld.setText(s.concat("."));
            s = txtfld.getText();
        }
        if (o == reset) {
            txtfld.setText("");
            s = txtfld.getText();
            total1 = 0;
        }
    }

    private void clearfields() {
        first=0;
        second=0;
        ope="";
        flag = 0;
        total1 = 0;
        s="";
    }
}


//System.out.println(stem[0]);