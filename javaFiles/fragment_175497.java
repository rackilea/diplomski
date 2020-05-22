package password;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Password extends JFrame{

String[] contents = {"Name 1", "Name 2"};
protected JTextField newAdress;
protected JPanel panel1, panel2; //2 panels for a more organized approach...
protected JComboBox  pwSelection;// ?
protected JTextField pwOutput;
protected JButton enc_btn;
protected JButton dec_btn;

public Password(){          //Constructor of the class, initialize stuff here...

    super("Shinny title");
    //1. Initialize all your atributtes...
    newAdress = new JTextField();
    panel1 = new JPanel();
    panel2 = new JPanel();
    pwSelection = new JComboBox(contents);
    pwOutput= new JTextField();
    enc_btn = new JButton("First button");
    dec_btn = new JButton("Second Button");
    //Set layouts..
    panel1.setLayout(new GridLayout(3,1));          
panel2.setLayout(new FlowLayout());

    //Add items to panel 1...
    panel1.add(new JLabel("Adress:"));  //A more simple aproach for creating a label...
    panel1.add(newAdress);
    panel1.add(pwSelection);
    panel1.add(enc_btn);
    panel1.add(dec_btn);
    panel1.add(pwOutput);
    //Add items of panel 1 to panel 2...
    panel2.add(panel1);
    add(panel2);

    setSize(300,300);
    setVisible(true);

    //Proper way of stop the application at closing...
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}

//This is not necessary as everything should be implemented in the constructor.
/*
public JFrame run(){
    JFrame mainFrame= new JFrame ("Password");
    mainFrame.setContentPane(new Password().panel1);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.pack();
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setSize(400, 200);
    mainFrame.setResizable(false);
    mainFrame.setVisible(true);

    pwSelection.addItem("Name 1");
    dec_btn.setText("Example");

    setVisible(true);
    return mainFrame;
}