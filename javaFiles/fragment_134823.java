import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sushi implements ActionListener {
private JFrame frame;
private JPanel appPanel;
private JPanel sideAppPanel;
private JPanel mainAppPanel;

private JButton appItemButton1;
private JButton appItemButton2;
private JButton appItemButton3; //added
private JButton appItemButton4;
private JButton appItemButton5;
private JButton appItemButton6;
private JButton appItemButton7;
private JButton appItemButton8;
private JButton appItemButton9;
private JButton appButton;
private JButton mainButton;
private JButton sidesButton;
private JButton dessertButton;
private JButton drinksButton;
private JButton totalButton;

private JLabel blank1;
private JLabel blank2;
private JLabel blank3;
private JLabel blank4;
private JLabel blank5;
private JLabel blank6;
private JLabel blank7;
private JLabel blank8;
private JLabel blank9;
private JLabel blank10;
private JLabel blank11;
private JLabel blank12;
private JLabel blank13;
private JLabel blank14;
private JLabel blank15;
private JLabel blank16;
private JLabel blank17;
private JLabel blank18;
private JLabel blank19;



public static void main(String args[]) {
    Sushi lol = new Sushi();
}

public Sushi() {

    // frame settings
    frame = new JFrame("sushi master");
    frame.setSize(700, 700);
    frame.setResizable(false);
    frame.setLocation(300, 100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());    //changed

    // sidepanel
    sideAppPanel = new JPanel();
    sideAppPanel.setSize(100, 700);
    sideAppPanel.setBackground(Color.red);
    sideAppPanel.setLocation(0, 0);
    sideAppPanel.setLayout(new GridLayout(18, 0));
    frame.add(sideAppPanel, BorderLayout.WEST); //changed

    // items in side panel
    appButton = new JButton("Appetizer");
    mainButton = new JButton("Main course");
    sidesButton = new JButton("Sides");
    drinksButton = new JButton("Drinks");
    totalButton = new JButton("Total");
    blank1 = new JLabel(" ");
    blank2 = new JLabel(" ");
    blank3 = new JLabel(" ");
    blank4 = new JLabel(" ");
    blank5 = new JLabel("");

    sideAppPanel.add(blank1);
    sideAppPanel.add(appButton);
    sideAppPanel.add(blank2);
    sideAppPanel.add(mainButton);
    sideAppPanel.add(blank3);
    sideAppPanel.add(sidesButton);
    sideAppPanel.add(blank4);
    sideAppPanel.add(drinksButton);
    sideAppPanel.add(blank5);
    sideAppPanel.add(totalButton);

    // items in main panel
    blank5 = new JLabel(" ");
    blank6 = new JLabel(" ");
    blank7 = new JLabel(" ");
    blank8 = new JLabel(" ");
    blank9 = new JLabel(" ");
    blank10 = new JLabel(" ");
    blank11 = new JLabel(" ");
    blank12 = new JLabel(" ");
    blank13 = new JLabel(" ");
    blank14 = new JLabel(" ");
    blank15 = new JLabel(" ");
    blank16 = new JLabel(" ");

    appItemButton1 = new JButton("1");
    appItemButton2 = new JButton("2");
    appItemButton3 = new JButton("3");
    appItemButton4 = new JButton("4");

    appItemButton5 = new JButton("5");
    appItemButton6 = new JButton("6");
    appItemButton7 = new JButton("7");
    appItemButton8 = new JButton("8");
    appItemButton9 = new JButton("9");

    // adding action listening to side panel buttons
    appButton.addActionListener(this);

}

public void actionPerformed(ActionEvent event) {
    if (event.getSource() == appButton) {
        mainAppPanel = new JPanel();
        mainAppPanel.setSize(600, 700);
        mainAppPanel.setLocation(100, 0);
        mainAppPanel.setBackground(Color.blue);
        mainAppPanel.setLayout(new GridLayout(5, 4, 20, 20));
        frame.add(mainAppPanel, BorderLayout.CENTER);   //changed
        appItemButton1 = new JButton("1");
        appItemButton2 = new JButton("2");
        appItemButton3 = new JButton("3");
        appItemButton4 = new JButton("4");

        appItemButton5 = new JButton("5");
        appItemButton6 = new JButton("6");
        appItemButton7 = new JButton("7");
        appItemButton8 = new JButton("8");
        appItemButton9 = new JButton("9");

        mainAppPanel.add(appItemButton1);
        mainAppPanel.add(appItemButton2);
        mainAppPanel.add(appItemButton3);
        mainAppPanel.add(appItemButton4);
        mainAppPanel.add(appItemButton5);
        mainAppPanel.add(appItemButton6);
        mainAppPanel.add(appItemButton7);
        mainAppPanel.add(appItemButton8);
        mainAppPanel.add(appItemButton9);
        mainAppPanel.add(blank5);
        mainAppPanel.add(blank6);
        mainAppPanel.add(blank7);

        frame.validate();   //added
    }
}
}