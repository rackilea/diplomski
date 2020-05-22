import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CardLayoutDemo extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JButton pan1,pan2;
    private JPanel mainPanel;
    public CardLayoutDemo(){
        cardLayout = new CardLayout();
         mainPanel = new JPanel(cardLayout);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        pan1 = new JButton("To Second Panel");
        pan2= new JButton ("To First Panel");
        pan1.addActionListener(this);
        pan2.addActionListener(this);
        p1.setBackground(Color.green);
        p2.setBackground(Color.BLUE.brighter());
        p1.add(pan1);
        p2.add(pan2);
        mainPanel.add(p1,"1");
        mainPanel.add(p2,"2");
        cardLayout.show(mainPanel, "1");

        add(mainPanel);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==pan1)
            cardLayout.show(mainPanel, "2");
        else if(ev.getSource()==pan2)
            cardLayout.show(mainPanel, "1");
    }

    public static void main(String...args){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
              new CardLayoutDemo().setVisible(true);

            }
        });
    }
}