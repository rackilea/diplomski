import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lucky7Slots {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lucky 7 Slot Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Lucky7SlotsPanel());

        frame.pack();
        frame.setVisible(true);
    }
}

class Lucky7SlotsPanel extends JPanel {
    private JButton pull, reset;
    private JLabel label, labelS1, labelS2, labelO, labelS3, labelM, labelWin;
    private JPanel buttonPanel;

    public Lucky7SlotsPanel() {
        pull = new JButton("PULL");
        reset = new JButton("RESET");

        ButtonListener listener = new ButtonListener();
        pull.addActionListener(listener);
        reset.addActionListener(listener);

        label = new JLabel("Lucky 7 Slot Machine");
        labelS1 = new JLabel("");
        labelS2 = new JLabel("");
        labelO = new JLabel("");
        labelS3 = new JLabel("");
        labelM = new JLabel("");
        labelWin = new JLabel("");

        // RPC Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(390, 70));
        buttonPanel.setBackground(Color.orange);
        buttonPanel.add(pull);
        buttonPanel.add(reset);

        // Slot 1 Panel
        JPanel panelS1 = new JPanel();
        panelS1.setPreferredSize(new Dimension(210, 115));
        panelS1.setBackground(Color.blue);
        JLabel S1label = new JLabel("Slot 1");
        panelS1.add(S1label);
        panelS1.add(labelS1);
        labelS1.setFont(new Font("Arial", Font.BOLD, 60));
        S1label.setFont(new Font("Arial", Font.BOLD, 30));

        // Slot2 Panel
        JPanel panelS2 = new JPanel();
        panelS2.setPreferredSize(new Dimension(210, 115));
        panelS2.setBackground(Color.cyan);
        JLabel S2label = new JLabel("Slot 2");
        panelS2.add(S2label);
        panelS2.add(labelS2);
        labelS2.setFont(new Font("Arial", Font.BOLD, 60));
        S2label.setFont(new Font("Arial", Font.BOLD, 30));

        // Slot 3 Panel
        JPanel panelS3 = new JPanel();
        JLabel S3label = new JLabel("Slot 3");
        panelS3.setPreferredSize(new Dimension(210, 115));
        panelS3.setBackground(Color.magenta);
        panelS3.add(S3label);
        panelS3.add(labelS3);
        labelS3.setFont(new Font("Arial", Font.BOLD, 60));
        S3label.setFont(new Font("Arial", Font.BOLD, 30));

        // Outcome Panel
        JPanel panelO = new JPanel();
        panelO.setPreferredSize(new Dimension(390, 30));
        panelO.setBackground(Color.lightGray);
        panelO.add(labelO);
        labelO.setFont(new Font("Arial", Font.BOLD, 20));

        // Money Panel
        JPanel panelM = new JPanel();
        panelM.setPreferredSize(new Dimension(126, 60));
        panelM.setBackground(Color.green);
        panelM.add(labelM);
        labelM.setFont(new Font("Arial", Font.BOLD, 13));

        // Wins Panel
        JPanel panelWin = new JPanel();
        panelWin.setPreferredSize(new Dimension(127, 60));
        panelWin.setBackground(Color.pink);
        panelWin.add(labelWin);
        labelWin.setFont(new Font("Arial", Font.BOLD, 14));

        setPreferredSize(new Dimension(700, 300));
        setBackground(Color.red);
        add(label);
        add(buttonPanel);
        add(panelS1);
        add(panelS2);
        add(panelS3);
        add(panelO);
        add(panelM);
        add(panelWin);

    }

    private class ButtonListener implements ActionListener {
        Random gen = new Random();
        int Win = 0, slot1, slot2, slot3, playpic;
        double Money=1000, jackpot, num3, num2, Pull, money=1000;
        double JACKPOT;
        double NUM3;
        double NUM2;
        double PULL;
        double MONEY;

        public void actionPerformed(ActionEvent event) {
            Object choice = event.getSource();
            slot1 = gen.nextInt(9) + 1;
            slot2 = gen.nextInt(9) + 1;
            slot3 = gen.nextInt(9) + 1;
            jackpot = 0;
            num3 = 0;
            num2 = 0;
            Pull = 0;
            MONEY = 1000.0;
            PULL = -25.0;
            JACKPOT = 1000.0;
            NUM3 = 500.0;
            NUM2 = 100.0;
            if (choice == pull) {
                money=money-25;
                if (slot1 == 1)
                    labelS1.setText("                   One                ");
                else if (slot1 == 2)
                    labelS1.setText("                   Two                 ");
                else if (slot1 == 3)
                    labelS1.setText("                 Three                 ");
                else if (slot1 == 4)
                    labelS1.setText("                 Four                  ");
                else if (slot1 == 5)
                    labelS1.setText("                 Five                  ");
                else if (slot1 == 6)
                    labelS1.setText("                 Six                   ");
                else if (slot1 == 7)
                    labelS1.setText("                 Seven                 ");
                else if (slot1 == 8)
                    labelS1.setText("                 Eight                 ");
                else
                    labelS1.setText("                 Nine                  ");

                if (slot2 == 1)
                    labelS2.setText("                   One                ");
                else if (slot2 == 2)
                    labelS2.setText("                   Two                 ");
                else if (slot2 == 3)
                    labelS2.setText("                 Three                 ");
                else if (slot2 == 4)
                    labelS2.setText("                 Four                  ");
                else if (slot2 == 5)
                    labelS2.setText("                 Five                  ");
                else if (slot2 == 6)
                    labelS2.setText("                 Six                   ");
                else if (slot2 == 7)
                    labelS2.setText("                 Seven                 ");
                else if (slot2 == 8)
                    labelS2.setText("                 Eight                 ");
                else
                    labelS2.setText("                 Nine                  ");

                if (slot3 == 1)
                    labelS3.setText("                   One                ");
                else if (slot3 == 2)
                    labelS3.setText("                   Two                 ");
                else if (slot3 == 3)
                    labelS3.setText("                 Three                 ");
                else if (slot3 == 4)
                    labelS3.setText("                 Four                  ");
                else if (slot3 == 5)
                    labelS3.setText("                 Five                  ");
                else if (slot3 == 6)
                    labelS3.setText("                 Six                   ");
                else if (slot3 == 7)
                    labelS3.setText("                 Seven                 ");
                else if (slot3 == 8)
                    labelS3.setText("                 Eight                 ");
                else
                    labelS3.setText("                 Nine                  ");
            }

            if (choice == pull)
                playpic = 1;
            else
                playpic = 2;

            switch (playpic) {
            case 1:
                if (slot1 == 7 && slot2 == 7 && slot3 == 7) {
                    Win++;
                    Pull++;
                    //jackpot++;
                    money=money+1000;

                    labelO.setText("LUCKY NUMBER 7!! JACKPOT!!!!");
                } else if (slot1 == slot2 && slot1 == slot3) {
                    labelO.setText("You matched 3 numbers!! You are a winner!!");
                    Win++;
                    Pull++;
                    num3++;
                    money=money+500;
                } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
                    labelO.setText("You matched two numbers! You get a prize!");
                    Win++;
                    Pull++;
                    num2++;
                    money=money+100;
                } else {
                    labelO.setText("Sorry but you suck, LOSER!!");
                    Pull++;
                }
                break;
            default:
                labelS1.setText("");
                labelS2.setText("");
                labelS3.setText("");
                labelO.setText("");
                Win = 0;
                Money = 1000.0;
            }
//          money = 0;
//          Money = MONEY + (PULL * Pull) + (JACKPOT * jackpot) + (NUM3 * num3) + (NUM2 * num2);
//          money += Money;
            labelWin.setText("Player Wins: " + Win);
            labelM.setText("Money Left: " + money);
        }

    }
}