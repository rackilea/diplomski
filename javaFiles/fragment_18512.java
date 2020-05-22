package com.ggl.drawing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawFrame implements Runnable {
    private final int WIDTH = 500;
    private final int HEIGHT = 300;

    private JFrame frame;

    private GUIModel model;

    public DrawFrame() {
        this.model = new GUIModel("A");
    }

    @Override
    public void run() {
        frame = new JFrame("Draw Letters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createSelectionPanel(), BorderLayout.WEST);
        frame.add(new DrawPanel(WIDTH, HEIGHT, model), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createSelectionPanel() {
        JPanel numberPanel = new JPanel();
        ButtonListener listener = new ButtonListener();

        JButton number1 = new JButton("A");
        number1.addActionListener(listener);

        JButton number2 = new JButton("B");
        number2.addActionListener(listener);

        numberPanel.setLayout(new GridLayout(0, 2));
        numberPanel.add(number1);
        numberPanel.add(number2);

        return numberPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            model.setDisplayString(event.getActionCommand());
        }
    }

    // creates a drawing frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DrawFrame());
    }
}