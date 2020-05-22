import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TestGUI {

    private String name;
    private JTextField textfield = new JTextField(30);
    private JTextArea  textarea = new JTextArea(30,30);

    private void displayGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Checkem");        

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        JScrollPane scrolltxt = new JScrollPane();
        scrolltxt.setViewportView(textarea);
        scrolltxt.setWheelScrollingEnabled(true);

        JLabel label = new JLabel("Enter the Name of the file:");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(2,2,2,2);

        panel.add(label,c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(scrolltxt,c);      

        JButton button = new JButton("Search");
        c.gridx = 1;
        c.gridy = 1;
        panel.add(button,c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(textfield,c);


        frame.getContentPane().add(panel, BorderLayout.NORTH);      
        //frame.setSize(800,800);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                /*Checkem record = new Checkem();
                name = textfield.getText();         
                String [] print = record.run(name);

                for (int i=0;i<print.length;i++)
                {
                    if(print[i] == null || print[i].isEmpty())
                    {
                        continue;
                    }
                    else
                    {
                        textarea.append(print[i] + "\n");
                    }
                }*/
            }
        });
    }

    public static void main( String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new TestGUI().displayGUI();
            }
        };
        EventQueue.invokeLater(r);
    }
}