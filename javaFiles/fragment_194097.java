import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class refurbished extends JFrame implements ActionListener {

    ArrayList<String> names;
    JButton add;
    JTextField inputName;
    JScrollPane scrollName;
    JList nameList;
    DefaultListModel model;          <-- declare DefaultListModel

    public refurbished() {
        setSize(700, 500);
        setLayout(null);

        names = new ArrayList<String>();

        add = new JButton("Add");
        add.setBounds(25, 200, 90, 30);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);

        inputName = new JTextField();
        inputName.setBounds(150, 350, 150, 30);

        model = new DefaultListModel();                <-- Initialize model
        nameList = new JList(model);                   <-- set model to list

        scrollName = new JScrollPane(nameList);
        scrollName.setBounds(150, 75, 150, 200);

        getContentPane().add(add);
        getContentPane().add(inputName);
        getContentPane().add(scrollName);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent buttonclick) {
        if (buttonclick.getSource() == add) {
            //names.add(inputName.getText().toLowerCase());   
            //nameList = new JList(names.toArray());        <-- don't need all this
            //scrollName = new JScrollPane(nameList);
            //scrollName.setBounds(150, 75, 150, 200);
            String name = inputName.getText();           <-- get input
            names.add(name);                             
            model.addElement(name);                      <-- add name to model      
        }
    }

    public static void main(String[] args) {
        refurbished r = new refurbished();
    }
}