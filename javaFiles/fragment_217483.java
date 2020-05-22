package javaapplication1;

import javax.swing.JOptionPane;

public class Room{

    public static void main(String[] args) {
        String sample = dialog();
        System.out.println(sample);
    }

    public static String dialog() {
        String sample = JOptionPane.showInputDialog(null, "Insert Value", "Enter amount ", JOptionPane.QUESTION_MESSAGE); 
        if (sample.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error!", "No Value Detected", JOptionPane.ERROR_MESSAGE);
            dialog();
        }
        System.out.println(sample+" from the bottom line.");
        return sample;
    }