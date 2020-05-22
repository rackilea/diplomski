import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame{


    ArrayList<String> numbers = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    JButton button1;
    JButton button2;
    JButton button3;
    JButton doneButton;
    JPanel row1 = new JPanel();
    JPanel textLabelRow = new JPanel();
    JLabel label = new JLabel();
    JPanel row3 = new JPanel();

    public void create(){
        setTitle("S-O");
        setSize(500,200);

        setLayout(new GridLayout(3,1,10,10));

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        doneButton = new JButton("Done");
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        button1.addActionListener(new Button1Listener());
        button2.addActionListener(new Button2Listener());
        button3.addActionListener(new Button3Listener());
        doneButton.addActionListener(new doneButtonListener());


        textLabelRow.add(label);
        row3.add(doneButton);
        add(row1);
        add(textLabelRow);
        add(row3);


        setVisible(true);
    }

    private class Button1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sb.append(button1.getText().toString());
        }       
    }

    private class Button2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sb.append(button2.getText().toString());
        }       
    }
    private class Button3Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            sb.append(button3.getText().toString());
        }       
    }
    private class doneButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(sb.toString());
            numbers.add(sb.toString());
            sb = new StringBuilder();
        }
    }

    public static void main(String[] args){
        GUI start = new GUI();
        start.create();
    }

}