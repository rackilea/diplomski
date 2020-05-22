import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;

public class SwingThread2 {
    protected static final int MAX_VALUE = 5; // our constant
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingThread2 window = new SwingThread2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SwingThread2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        // frame.setBounds(100, 100, 450, 300); // avoid this
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea(15, 40);
        scrollPane.setViewportView(textArea);

        JButton btnNewButton = new JButton("New button");
        scrollPane.setColumnHeaderView(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // delay between timer ticks: 1000
                int timerDelay = 1000;
                new Timer(timerDelay, new ActionListener() {
                    private int counter = 0;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // timer's stopping condition
                        if (counter >= MAX_VALUE) { // MAX_VALUE is a constant int = 5
                            ((Timer) e.getSource()).stop();
                        } else {
                            textArea.append("Value " + counter + "\n");
                        }
                        counter++; // increment timer's counter variable
                    }
                }).start();
            }
        });

        // better to avoid setting sizes but instead to
        // let the components size themselves vis pack
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}