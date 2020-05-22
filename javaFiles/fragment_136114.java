import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    private final static String PANEL1 = "panel 1";
    private final static String PANEL2 = "panel 2";

    public Test() {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Panel 2"));

        //Create the panel that contains the "cards".
        final JPanel cards = new JPanel(new CardLayout());
        cards.add(panel1, PANEL1);
        cards.add(panel2, PANEL2);

        //create button to allow chnage to next card
        JButton buttonNext = new JButton(">");
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.next(cards);
            }
        });

        //create button to allow chnage to previous card
        JButton buttonPrev = new JButton("<");
        buttonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());//get cards
                cl.previous(cards);
            }
        });

        //create panel to hold buttons which will allow switching between cards
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonPrev);
        buttonPanel.add(buttonNext);


        frame.add(cards);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}