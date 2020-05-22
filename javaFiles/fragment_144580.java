import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JApplet;
import javax.swing.*;


    public class Example extends JApplet {

        JPanel panel1,panel2,mainPanel;
        JButton start,stop;
        CardLayout cl = new CardLayout();
        @Override
        public void init() {
            panel1 = new JPanel();
            panel1.setBackground(Color.red);
            panel1.setLayout(new BorderLayout());
            panel2 = new JPanel();
            panel2.setBackground(Color.blue);
            panel2.setLayout(new BorderLayout());
            start = new JButton("Start");
            stop = new JButton("stop");
            panel1.add(start,BorderLayout.SOUTH);
            panel2.add(stop,BorderLayout.SOUTH);
            mainPanel = new JPanel();
            mainPanel.setLayout(cl);
            mainPanel.add(panel1,"First Panel");
            mainPanel.add(panel2, "Second Panel");
            start.addActionListener((ActionEvent e) -> {
                newGame();
            });
            stop.addActionListener((ActionEvent e) ->{
                endGame();
            });
            this.add(mainPanel);
        }

        public void newGame()
        {
            cl.show(mainPanel, "Second Panel");
        }
        public void endGame()
        {
            cl.show(mainPanel,"First Panel");
        }
    }