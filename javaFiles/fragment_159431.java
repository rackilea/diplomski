import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScherm extends JFrame {
    static StartScherm frame1; 
    static StartScherm frame2; 

    public static void main(String[] args) {

        frame1 = new StartScherm();
        frame1.setSize(800, 800);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("CityTours Default Language");
        JPanel Paneel = new Paneel();
        frame1.setContentPane(Paneel);
        frame1.setVisible(true);


        frame2 = new StartScherm();
        frame2.setSize(800, 800);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("CityTours English Version");
        JPanel Paneel2 = new Paneel();
        frame2.setContentPane(Paneel2);
        frame2.setVisible(false);
    }
}

class Paneel extends JPanel {
    private JButton Eng, LoginAdmin, LoginUser;
    private JTextField Text;

    public Paneel() {

        setLayout(null);

        Eng = new JButton("Bring me to the English version");
        Eng.setBounds(250, 20, 300, 20);
        Eng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(StartScherm.frame1.isVisible()) {
                   StartScherm.frame1.setVisible(false);
                   StartScherm.frame2.setVisible(true);
               } else {
                   StartScherm.frame1.setVisible(true);
                   StartScherm.frame2.setVisible(false);
               }
            }
        });

        Text = new JTextField(" Welkom bij CityTours ");
        Text.setBounds(100, 80, 600, 600);
        Text.setEditable(false);

        LoginAdmin = new JButton("Login administrator");
        LoginAdmin.setBounds(100, 720, 200, 20);

        LoginUser = new JButton("Login gebruiker");
        LoginUser.setBounds(500, 720, 200, 20);

        add(Eng);
        add(Text);
        add(LoginAdmin);
        add(LoginUser);

    }
}