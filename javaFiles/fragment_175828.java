import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class StackPanel extends JPanel {

    JPanel west, westSub1, east, south, southSub1;
    JTextArea infoText, popText, pushText, peekText, resultText;
    JLabel aTitle, bTitle, cTitle, Result;
    JButton push, pop, peek, test;

    public StackPanel() {

        // Creating JPanels
        setLayout(new BorderLayout());

        // Creating JLabels / JTextArea
        aTitle = new JLabel("Operations");
        bTitle = new JLabel("Data Structure Contents");

        west = new JPanel();
        //you need to set layout manager to the panel, to lay out its components
        west.setLayout(new BorderLayout());
        west.setPreferredSize(new Dimension(200,200));
        west.setBorder(BorderFactory.createLineBorder(Color.black));
        west.setBackground(new Color(234,237,242));
        add(west, BorderLayout.WEST);

        west.add(aTitle, BorderLayout.NORTH);//use panel's layout manager

        //you have 4 rows so GridLayout(3,2) is wrong
        westSub1 = new JPanel(new GridLayout(4,2));

        //for a grid layout: add components in the right order
        push = new JButton("PUSH");
        westSub1.add(push);

        pushText = new JTextArea("pushtxt");
        westSub1.add(pushText);

        pop = new JButton("POP") ;
        westSub1.add(pop);

        popText = new JTextArea("poptxt");
        westSub1.add(popText);

        peek = new JButton("PEEK");
        westSub1.add(peek);

        peekText = new JTextArea("g");
        westSub1.add(peekText);

        test = new JButton("TEST");
        westSub1.add(test);

        resultText = new JTextArea("");
        westSub1.add(resultText);

        west.add(westSub1, BorderLayout.CENTER);//use panel's layout manager

        east = new JPanel();
        east.setPreferredSize(new Dimension(400,100));
        east.setBorder(BorderFactory.createLineBorder(Color.black));
        east.setBackground(new Color(255,255,255));

        east.add(bTitle);
        add(east, BorderLayout.CENTER);

        south = new JPanel();
        //you need to set layout manager to the panel, to lay out its components
        south.setLayout(new BorderLayout());
        south.setPreferredSize(new Dimension(100,150));
        south.setBorder(BorderFactory.createLineBorder(Color.black));
        south.setBackground(new Color(240,240,240));
        add(south, BorderLayout.SOUTH);

        cTitle = new JLabel("Information");
        south.add(cTitle, BorderLayout.NORTH); //use panel's layout manager
        infoText = new JTextArea("This is where commands will be displayed.");
        south.add(infoText, BorderLayout.CENTER);
    }

    public static void main(String[] args){

          JFrame frame = new JFrame();
          frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

          frame.getContentPane().add(new StackPanel());
          frame.pack();
          frame.setVisible(true);
    }
}