package gnu;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JButton applyButton = new JButton("New Game");
    GridLayout experimentLayout = new GridLayout(0, 6);

    public Main(String name) {
        super(name);
        setResizable(false);
    }


    public void addComponentsToPane(final Container pane) {

        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 3));

        //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 2.5) + 5,
                (int) (buttonSize.getHeight() * 3.5) + 50 * 2));

        //Add buttons to experiment with Grid Layout

        for (int i = 1; i < 7; i++) {
            if(i==1) compsToExperiment.add(new Label(""));
            else compsToExperiment.add(new Label("" + (i-1) ));
        }

        for (int i = 0; i < 30; i++) {
            if (i == 0) compsToExperiment.add(new Label("A"));
            else if (i == 6) compsToExperiment.add(new Label("B"));
            else if (i == 12) compsToExperiment.add(new Label("C"));
            else if (i == 18) compsToExperiment.add(new Label("D"));
            else if (i == 24) compsToExperiment.add(new Label("E"));
            else compsToExperiment.add(new JButton("~"));
        }

        //Add controls to set up horizontal and vertical gaps

        controls.add(applyButton);

        //Process the Apply gaps button press
        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Set up the layout of the buttons
                experimentLayout.layoutContainer(compsToExperiment);
            }
        });
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        Main frame = new Main("Battleships");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
    /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}