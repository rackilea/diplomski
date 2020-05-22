import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonExample {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        // create the jframe
        JFrame jframe = new JFrame("Question");
        // create the answers
        String[] answer = { "red", "green", "yellow", "blue, no, red, no... arrrrrg" };
        // create the radio buttons
        JRadioButton answerA = new JRadioButton("A) " + answer[0]);
        JRadioButton answerB = new JRadioButton("B) " + answer[1]);
        JRadioButton answerC = new JRadioButton("C) " + answer[2]);
        JRadioButton answerD = new JRadioButton("D) " + answer[3]);
        // create the button group
        ButtonGroup group = new ButtonGroup();
        group.add(answerA);
        group.add(answerB);
        group.add(answerC);
        group.add(answerD);
        // add the question to the jframe
        jframe.add(new JLabel("What is your favorite colour?"), BorderLayout.NORTH);
        // create gridbag layout and constraints
        GridBagLayout gbl = new GridBagLayout();
        // create the panel using the gbl
        JPanel pan = new JPanel(gbl);
        // create the constraints
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        // answer 1
        cons.gridx = 0;
        cons.gridy = 1;
        pan.add(answerA, cons);
        // answer 1
        cons.gridx = 0;
        cons.gridy = 2;
        pan.add(answerB, cons);
        // answer 1
        cons.gridx = 0;
        cons.gridy = 3;
        pan.add(answerC, cons);
        // answer 1
        cons.gridx = 0;
        cons.gridy = 4;
        pan.add(answerD, cons);
        // add the panel to the jframe
        jframe.add(pan, BorderLayout.CENTER);
        // show the jframe
        jframe.setSize(400, 400);
        jframe.setVisible(true);
    }
}