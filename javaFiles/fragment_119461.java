import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Experiment extends JFrame {

    ArrayList<JTextField> fruitsindex;
    ArrayList<String>fruits; //use to keep fruit name
    int serial =0;

    private JTextField userInput;
    private JLabel fruitName;

    public Experiment(){

        fruits=new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Pomegranate");
        fruits.add("Guava");
        fruits.add("Papapya");
        fruits.add("Banana");

        //initialize user input JtextFiield
        userInput = new JTextField(2);
        userInput.setPreferredSize(new Dimension(15,40));
        userInput.setToolTipText("Enter fruit index (0-6)");
        //add key listener
        userInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int c=e.getKeyCode();
                if(c == KeyEvent.VK_ENTER) {
                    processInput();
                }
            }

        });
        add(userInput, BorderLayout.WEST);

        //initialize fruit name label
        fruitName = new JLabel("Enter fruit index");
        fruitName.setPreferredSize(new Dimension(140,40));
        add(fruitName, BorderLayout.EAST);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void processInput() {

        //error msg will be over written if input is valid 
        fruitName.setText("Wrong input");

        try {
            String inputString = userInput.getText();
            int inputInt = Integer.valueOf(inputString);
            if((inputInt >=0) && (inputInt < fruits.size())) {

                fruitName.setText(fruits.get(inputInt));
                userInput.setText(""); //clear input

            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        repaint();
    }

    public static void main(String[] args) {
        //no need to keep a reference if you don't use it
        //Experiment e=
        new Experiment();
    }
}