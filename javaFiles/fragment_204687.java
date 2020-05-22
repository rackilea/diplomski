package com.ggl.testing;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GradeAnalysis implements Runnable {

    private static final Insets normalInsets = new Insets(10, 10, 0, 10);
    private static final Insets finalInsets = new Insets(10, 10, 10, 10);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GradeAnalysis());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createMainPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        GridBagConstraints gbc = new GridBagConstraints();

        // Adding the JPanels. Panel for instructions
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        // JLabel for the Instructions.
        JTextArea instructionTextArea = new JTextArea(5, 30);
        instructionTextArea.setEditable(false);
        instructionTextArea.setLineWrap(true);
        instructionTextArea.setWrapStyleWord(true);
        instructionTextArea.setText(getInstructions());
        JScrollPane instructionScrollPane = new JScrollPane(instructionTextArea);
        addComponent(panel, instructionScrollPane, 0, gridy++, 3, 1,
                finalInsets, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL);

        // JLabels for Assignment/Grade/Weight(Percent)
        JLabel label1 = new JLabel("Assignment");
        label1.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label1, 0, gridy, 1, 1, finalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        JLabel label2 = new JLabel("Mark");
        label2.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label2, 1, gridy, 1, 1, finalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        JLabel label3 = new JLabel("Weight");
        label3.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label3, 2, gridy++, 1, 1, finalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        // JLabel Numbers for the number list of assignments at the side.
        JLabel number = new JLabel("1");
        number.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, number, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        // JTextfield for Mark
        JTextField mark = new JTextField(20);
        mark.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, mark, 1, gridy, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        // JTextfield for Weight
        JTextField weight = new JTextField(20);
        weight.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, weight, 2, gridy++, 1, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        return panel;
    }

    private String getInstructions() {
        return "Instructions: Type in the grades you’ve received, along with the weights "
                + "they’ll have in the determination of your overall average. After you "
                + "press ‘Calculate’, the results will show your average so far. Every "
                + "grade you enter must be a non-negative number, and every "
                + "percentage/weight you enter must be a positive number :)";
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

}