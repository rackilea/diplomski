import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITemplate {
    JFrame myMainWindow = new JFrame("Title");
    JPanel  firstPanel = new JPanel();

    private void runGUI() {
        myMainWindow.setBounds(10, 10, 400, 400);
        myMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myMainWindow.setLayout(new GridLayout(1,1));
        createFirstPanel();
        myMainWindow.getContentPane().add(firstPanel);
        myMainWindow.setVisible(true);
    }

    private void createFirstPanel() {
        firstPanel.setLayout(new FlowLayout());

        ImageIcon image1 = new ImageIcon("YourImage.ImageFileType");
        Image image2 = image1.getImage().getScaledInstance(300,300,0);
        ImageIcon image3 = new ImageIcon(image2);

        JButton jB = new JButton(image3);
        jB.addActionListener(new TheHandler());
        firstPanel.add(jB);
    }

    private class TheHandler implements ActionListener { //Changed thehandler to TheHandler
        public void actionPerformed(ActionEvent event) { //because it is a class
            //Do Something
        }
    }

    public static void main(String[] args) {
        GUITemplate gt = new GUITemplate();
        gt.runGUI();
    }
}