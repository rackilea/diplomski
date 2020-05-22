package com.ggl.testing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SorterTool2 implements Runnable {

    // Instance Variables
    private JButton jbtBubble, jbtSelection, jbtInsertion;
    private JLabel jlblSelect, jlblBubbleTime1, jlblBubbleTime2,
            jlblSelectionTime1, jlblSelectionTime2, jlblInsertion1,
            jlblInsertion2;
    private JTextField jtfBubbleField1, jtfBubbleField2, jtfSelectField1,
            jtfSelectField2, jtfInsertionField1, jtfInsertionField2;
    private JPanel content, topPanel, midPanel1, midPanel2, bottomPanel;
    private JComboBox<String> jCombo;

    private Random randNum = new Random();
    // private int max = 5000;
    private int[] myArray;
    // private long timerStart;
    // private long timerStop;

    private ListenerClass changes = new ListenerClass();

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Sorter Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels
        content = new JPanel(new GridLayout(4, 1, 0, 0));
        topPanel = new JPanel(new FlowLayout());
        midPanel1 = new JPanel();
        midPanel1.setLayout(new GridLayout(2, 3, 15, 5));
        midPanel2 = new JPanel();
        midPanel2.setLayout(new GridLayout(2, 3, 15, 5));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3, 30, 5));

        frame.add(content);

        content.add(topPanel);
        content.add(midPanel1);
        content.add(midPanel2);
        content.add(bottomPanel);
        midPanel1.setBorder(BorderFactory
                .createTitledBorder("Sorted Array Analysis"));
        midPanel2.setBorder(BorderFactory
                .createTitledBorder("Unsorted Array Analysis"));

        // Parts for the panels
        jlblSelect = new JLabel(
                "Please select the number of elements for the array");
        jlblBubbleTime1 = new JLabel("Bubble sort in milliseconds");
        jlblBubbleTime2 = new JLabel("Bubble sort in milliseconds");
        jlblSelectionTime1 = new JLabel("Selection sort in milliseconds");
        jlblSelectionTime2 = new JLabel("Selection sort in milliseconds");
        jlblInsertion1 = new JLabel("Insertion sort in milliseconds");
        jlblInsertion2 = new JLabel("Insertion sort in milliseconds");

        // Textfields
        jtfBubbleField1 = new JTextField(4);
        jtfBubbleField2 = new JTextField(4);
        jtfSelectField1 = new JTextField(4);
        jtfSelectField2 = new JTextField(4);
        jtfInsertionField1 = new JTextField(4);
        jtfInsertionField2 = new JTextField(4);

        String[] numbers = { "100", "1000", "10000" };
        jCombo = new JComboBox<String>(numbers);
        int test = Integer.valueOf(jCombo.getSelectedItem().toString());

        // create the list
        myArray = new int[test];
        for (int i = 0; i < test; i++) {
            // random numbers from 1 to max number:
            myArray[i] = randNum.nextInt(30) + 1;
        }

        // Add elements
        topPanel.add(jCombo);
        topPanel.add(jlblSelect);
        midPanel1.add(jlblBubbleTime1);
        midPanel1.add(jlblSelectionTime1);
        midPanel1.add(jlblInsertion1);
        midPanel1.add(jtfBubbleField1);
        midPanel1.add(jtfSelectField1);
        midPanel1.add(jtfInsertionField1);

        midPanel2.add(jlblBubbleTime2);
        midPanel2.add(jlblSelectionTime2);
        midPanel2.add(jlblInsertion2);
        midPanel2.add(jtfBubbleField2);
        midPanel2.add(jtfSelectField2);
        midPanel2.add(jtfInsertionField2);

        // Buttons
        jbtBubble = new JButton("Bubble");
        jbtSelection = new JButton("Selection");
        jbtInsertion = new JButton("Insertion");
        bottomPanel.add(jbtBubble);
        bottomPanel.add(jbtSelection);
        bottomPanel.add(jbtInsertion);

        // The Bubble sort button
        jbtBubble.addActionListener(changes);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SorterTool2());
    }

    class ListenerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // The iteration through the array
            // and the check value loop below it
            for (int i = 0; i < myArray.length - 1; i++) {
                for (int j = 0; j < myArray.length - i - 1; j++) {

                    if (myArray[j] > myArray[j + 1]) {
                        // The swap method if the index
                        // value is smaller
                        int temp = myArray[j + 1];
                        myArray[j + 1] = myArray[j];
                        myArray[j] = temp;

                    }
                }
            }

            jtfBubbleField2.setText(String.valueOf(1000));
        }

    }

}