package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Details extends JFrame {

    private static final long serialVersionUID = -555805219508469709L;

    private String[] navData = { "One", "Two", "Three", "Four" };

    private JPanel buttonPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Details frame = new Details();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public Details() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Test");

        buttonPanel = new JPanel();

        JPanel listPanel = new JPanel();
        final JList<String> list = new JList<String>(navData);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellHeight(50);
        list.setFixedCellWidth(70);
        list.setBorder(new EmptyBorder(10, 10, 10, 10));

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {

                String selectedItem = navData[list.getSelectedIndex()];
                switch (selectedItem) {
                case "One":
                    removeButtons(buttonPanel);
                    addButtons(buttonPanel, 1);
                    break;
                case "Two":
                    removeButtons(buttonPanel);
                    addButtons(buttonPanel, 2);
                    break;
                case "Three":
                    removeButtons(buttonPanel);
                    addButtons(buttonPanel, 3);
                    break;
                case "Four":
                    removeButtons(buttonPanel);
                    addButtons(buttonPanel, 4);
                    break;
                default:
                    break;
                }

            }
        });
        list.setSelectedIndex(3);

        listPanel.add(list);

        add(listPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.CENTER);

        pack();
    }

    public void removeButtons(JPanel panel) {
        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i++) {
            panel.remove(components[i]);
        }
    }

    public void addButtons(JPanel panel, int n) {
        for (int i = 0; i < n; i++) {
            JButton button = new JButton(navData[i]);
            panel.add(button);
        }
        panel.revalidate();
        panel.repaint();
    }
}