import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class GradePanel2 extends JPanel {

private JButton addEntry, calculate;
private JLabel name, grade, nameResult, gradeResult;
private JTextField nameField, gradeField, resultField;

public GradePanel2() {

    // Button to add entry to list
    addEntry = new JButton("Add entry to list");
    addEntry.addActionListener(new buttonListener());

    // Button to print all entries in correct format
    calculate = new JButton("Print all user grades");
    calculate.addActionListener(new buttonListener());

    //Create Labels
    name = new JLabel("Enter student name: ");
    nameField = new JTextField(10);
    nameField.addActionListener(new buttonListener());

    grade = new JLabel("Enter students mark: ");
    gradeField = new JTextField(5);
    gradeField.addActionListener(new buttonListener());


    //Bottom segment for result
    resultField = new JTextField();
    resultField.setOpaque(false);
    resultField.setEditable(false);

    setLayout(new BorderLayout());
    GridBagConstraints nameResultConstraints = new GridBagConstraints();//Constraints
    GridBagConstraints gradeResultConstraints = new GridBagConstraints();//Constraints


    //Button Panel
    JPanel ButtonPane = new JPanel();
    ButtonPane.setLayout(new BoxLayout(ButtonPane, BoxLayout.PAGE_AXIS));
    addEntry.setAlignmentX(CENTER_ALIGNMENT);
    calculate.setAlignmentX(CENTER_ALIGNMENT);
    ButtonPane.add(addEntry);
    ButtonPane.add(Box.createVerticalStrut(10));
    ButtonPane.add(calculate);

    //Label Panel
    JPanel labelPane = new JPanel();
    labelPane.setLayout(new BoxLayout(labelPane, BoxLayout.PAGE_AXIS));
    labelPane.add(name);
    labelPane.add(Box.createRigidArea(new Dimension (5,0)));
    labelPane.add(nameField);
    labelPane.add(Box.createRigidArea(new Dimension (0,2)));
    labelPane.add(grade);
    labelPane.add(Box.createRigidArea(new Dimension (5,0)));
    labelPane.add(gradeField);

    myBottomPanel mybottompanel = new myBottomPanel();//Object

    //Add all panels to the main panel
    add(labelPane, BorderLayout.NORTH); 
    add(ButtonPane, BorderLayout.CENTER);
    add(mybottompanel, BorderLayout.SOUTH);

    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(400, 300));
}

public class myBottomPanel extends JPanel{
    public myBottomPanel()
    {
        this.setLayout(new GridBagLayout());

        //Result Labels
         nameResult = new JLabel("NAME");
         gradeResult = new JLabel("GRADE");

         //Constraints
        GridBagConstraints nameResultConstraints = new GridBagConstraints();
        GridBagConstraints gradeResultConstraints = new GridBagConstraints();

        //Bottom Panel
        setBorder(BorderFactory.createTitledBorder("Students/Results"));
        setOpaque(false);
        setPreferredSize(new Dimension(0 , 100));

        nameResultConstraints.anchor = GridBagConstraints.LINE_START;
        nameResultConstraints.weightx = 0.5;
        nameResultConstraints.weighty = 0.5;

        add(nameResult,nameResultConstraints);
        add(gradeResult);

    }
}
public class buttonListener implements ActionListener{

    public void actionPerformed(ActionEvent event){

        String studentName;
        int studentMark;

        studentName = nameField.getText();
        String intMark = gradeField.getText();
        studentMark = Integer.parseInt(intMark);



    }
}

}