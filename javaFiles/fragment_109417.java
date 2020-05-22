package applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ClassFrame extends JFrame {


    private static final long serialVersionUID = 2451829341034438685L;

    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextArea = new JTextArea("Type Here!");
    public static JTextArea uneditTextArea = new JTextArea();

    // MA - Your String, defined here and usable throughout the class

    private String myString;

    public ClassFrame(String title) {

        // MA - Indent your code properly so that it's more readable to both you
        // and others

        //SET LAYOUT MANAGER (How it arranges components)
        setLayout(new BorderLayout());
        //////CREATE SWING COMPONENTS////////////
        //OUTPUT TEXT AREA
        uneditTextArea.setEditable(false);

        //INPUT TEXT AREA
        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE);

        //SET CONTENT PANE
        Container c = getContentPane();

        //ADD COMPONENTS TO CONTENT PANE        
        c.add(uneditTextArea, BorderLayout.CENTER);
        c.add(editTextArea, BorderLayout.SOUTH);
        c.add(inputButton, BorderLayout.WEST);

        ClassFrame.inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field myString to receive text from text area

                myString = editTextArea.getText();

                // MA - Don't use a space when you actually want an empty string.
                // As it stands, your code will test for a single space character.
                // You really want it to test whether the text area is empty.

                //editTextArea.setText(" ");

                // MA - Do this instead.  An empty string means the text area has
                // no input at all.

                editTextArea.setText("");

                System.out.println(myString);                
            }
        });
    }
}