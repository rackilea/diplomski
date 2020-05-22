package com.tobee.tests.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q2L04 extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new Q2L04();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    private JButton q2l;
    private JButton L2Q;
    private JButton exit;
    private JPanel panel;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 300;
    private JTextField txtQuartstoLiters;
    private JTextField Answer;

    public Q2L04() {

        super("Q2L04");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtQuartstoLiters = new JTextField(10);
        txtQuartstoLiters.setText("0");

        Answer = new JTextField(10);

        q2l = new JButton("Q2L");
        L2Q = new JButton("L2Q");
        exit = new JButton("EXIT");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 0));
        buttonsPanel.add(q2l);
        buttonsPanel.add(L2Q);

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.WEST);
        add(exit, BorderLayout.EAST);
        add(txtQuartstoLiters, BorderLayout.NORTH);
        add(Answer, BorderLayout.SOUTH);

        panel = new JPanel();

        panel.setBackground(Color.YELLOW);
        add(panel);
        setVisible(true);

        q2l.addActionListener(new QuartstoLiters2());

        //exit.addActionListener(new ExitButton());

        //L2Q.addActionListener(new LiterstoQuarts());
    }

    class QuartstoLiters implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double math = 0;
            int Stringtoint = 0;
            final double liters = 0.946353;

            String userQuarts = txtQuartstoLiters.getText();

            if(!userQuarts.equals(""))
            {
                Stringtoint = Integer.parseInt(userQuarts);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No input data was entered", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //try {
            //  if (userQuarts == null) throw (new Exception());

            //} catch (Exception exe) {
            //  JOptionPane.showMessageDialog(null, "No input data was entered", "Error", JOptionPane.ERROR_MESSAGE);
            //
            //  return;

            //}

            // the math to conver quartstoliters
            // 1 quart =0.946353 liters
            // quarts * 0.946353= numbers of liters
            math = Stringtoint * liters;
            // convert the double to a string
            Answer.setText(Double.toString(math));
        }
    }

    class QuartstoLiters2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double math = 0;
            int Stringtoint = 0;
            final double liters = 0.946353;

            String userQuarts = txtQuartstoLiters.getText();


            try {
                Stringtoint = Integer.parseInt(userQuarts);
            }  catch (NumberFormatException exe) {

                if(userQuarts.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty string not allowed", "Number Error", JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Only number is allowed", "Number Error", JOptionPane.ERROR_MESSAGE);

                return;
            }

            // the math to conver quartstoliters
            // 1 quart =0.946353 liters
            // quarts * 0.946353= numbers of liters
            math = Stringtoint * liters;
            // convert the double to a string
            Answer.setText(Double.toString(math));
        }
    }

}