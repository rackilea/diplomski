import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fishing {

public static void main(String[] args) {
    // This is where the variables got moved to
    final int[] total2 = {
            0
    };
    final int[] totalpoints = {
            0
    };

    //create Jframe
    JFrame Frame = new JFrame("Fishing Game");
    Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new BorderLayout());
    panel.setPreferredSize(new Dimension(600, 600));

    //two panels in main panel
    JPanel panelup = new JPanel();
    JPanel paneldown = new JPanel();
    panelup.setBackground(Color.white);

    //title image with word overlay
    ImageIcon pole1 = new ImageIcon("fishingpole.png");
    JLabel title = new JLabel(pole1);
    title.setBounds(150, 0, 325, 175);
    title.setText("Go Fishing?");
    title.setFont(new Font("Ravie", Font.BOLD, 30));
    title.setForeground(Color.green);
    title.setHorizontalTextPosition(JLabel.CENTER);
    title.setVerticalTextPosition(JLabel.CENTER);
    title.setOpaque(false);
    panelup.add(title);

    panelup.setPreferredSize(new Dimension(600, 375));
    panelup.setLayout(null);


    JLabel points = new JLabel("<html>Look what you caught!<br>(click start to keep going)</html> ");
    points.setForeground(Color.blue);
    points.setFont(new Font(null, Font.BOLD, 20));
    points.setBounds(10, 150, 450, 100);
    panelup.add(points);

    JTextField caught = new JTextField(20);
    caught.setSize(10, 10);
    caught.setFont(new Font("Times New Roman", Font.BOLD, 15));
    caught.setForeground(Color.RED);
    caught.setBounds(10, 230, 350, 30);
    panelup.add(caught);

    JTextField total = new JTextField(20);
    total.setSize(10, 10);
    total.setFont(new Font("Times New Roman", Font.BOLD, 15));
    total.setForeground(Color.RED);
    total.setBounds(325, 315, 150, 30);
    panelup.add(total);

    // STOP BUTTON
    JLabel End = new JLabel("<html>All Done?! Press Stop and Let's<br>see how well you did!<html>");
    End.setForeground(Color.blue);
    End.setFont(new Font(null, Font.BOLD, 20));
    End.setBounds(10, 310, 325, 50);
    panelup.add(End);

    JTextField single = new JTextField(20);
    single.setSize(10, 10);
    single.setFont(new Font("Times New Roman", Font.BOLD, 15));
    single.setForeground(Color.RED);
    single.setBounds(10, 275, 100, 30);
    panelup.add(single);


    //Label for asking user to continue
    ImageIcon bobber = new ImageIcon("bobber2.jpg");
    JButton start = new JButton(bobber);
    start.setBorderPainted(false);
    start.setBounds(350, 170, 100, 100);
    start.setText("Start!");
    start.setFont(new Font("Serif", Font.BOLD, 20));
    start.setForeground(Color.black);
    start.setHorizontalTextPosition(JLabel.CENTER);
    start.setVerticalTextPosition(JLabel.CENTER);
    start.setOpaque(false);
    panelup.add(start);

    ImageIcon bobber2 = new ImageIcon("bobber2.jpg");
    JButton stop = new JButton(bobber2);
    stop.setBorderPainted(false);
    stop.setBounds(450, 170, 100, 100);
    stop.setText("Stop!");
    stop.setFont(new Font("Serif", Font.BOLD, 25));
    stop.setForeground(Color.black);
    stop.setHorizontalTextPosition(JLabel.CENTER);
    stop.setVerticalTextPosition(JLabel.CENTER);
    stop.setOpaque(false);
    panelup.add(stop);


    start.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            double input = 0;
            int count = 0;
            int points2 = 0;
            int die;
            die = (int) (Math.random() * 6) + 1;

            if (die == 1) {
                caught.setText("Winner winner fish fry dinner! Catfish ");
                points2 = 10;

            }
            if (die == 2) {
                caught.setText("Nemo! Go straight to Jail. ");
                points2 = 15;
            }

            if (die == 3) {
                caught.setText("Stinky shoe boohoo! ");
                points2 = 5;
            }
            if (die == 4) {
                caught.setText("Whale of a fish, BIG TUNA ");
                points2 = 30;

            }
            if (die == 5) {
                caught.setText("Yumm Yumm Bass Pro");
                points2 = 25;
            }
            if (die == 6) {
                caught.setText("Is that a toilet bowl seat!? ");
                points2 = 10;
            }

            count += points2;

            single.setText(points2 + "");
            totalpoints[0] += points2;
        }
    });

    stop.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                total2[0] = Integer.parseInt(single.getText());
            } catch (NumberFormatException ee) {
                // If there is a blank input from single.getText();, then make total2 zero to avoid larger errors
                total2[0] = 0; // Another way to handle the exception
            }
            total.setText("" + totalpoints[0]);
        }

    });


    //paneldown image
    ImageIcon water = new ImageIcon("water.jpg");
    JLabel pic = new JLabel(water);
    paneldown.add(pic, BorderLayout.SOUTH);

    //panel positioning
    panel.add(panelup, BorderLayout.NORTH);
    panel.add(paneldown, BorderLayout.SOUTH);


    //set frame with panel
    Frame.add(panel);
    Frame.pack();
    Frame.setLocationRelativeTo(null);
    Frame.setSize(600, 600);
    Frame.setVisible(true);
}
}