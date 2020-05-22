package com.example;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class PropertyTest {

    public static void main(String[] args) {
        String value = (String) System.getProperties().get("file.encoding");

        JTextPane txt = new JTextPane();
        txt.setText(value);
        JFrame main = new JFrame();
        main.add(txt);
        main.setVisible(true);
    }
}