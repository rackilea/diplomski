import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class lay {

    JFrame frame;
    JPanel panelCont;
    JPanel panelOne;
    JButton buttonOne;
    CardLayout cards;

    PanelTwo panelTwo;

    public lay() {
        frame = new JFrame("Start");
        panelCont = new JPanel();
        panelOne = new JPanel();
        cards = new CardLayout();
        panelTwo = new PanelTwo(cards, panelCont);
        buttonOne = new JButton("Got to two");


        panelCont.setLayout(cards);

        panelOne.add(buttonOne);
        panelOne.setBackground(Color.BLUE);

        panelCont.add(panelOne, "1");
        panelCont.add(panelTwo, "2");
        cards.show(panelCont, "1");

        buttonOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(panelCont, "2");
            }
        });

        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new lay();
            }
        });
    }

}

class PanelTwo extends JPanel {

    JButton buttonTwo;
    CardLayout layout;
    JPanel panelCont;

    public PanelTwo(final CardLayout layout, final JPanel panelCont) {
        this.layout = layout;
        this.panelCont = panelCont;
        buttonTwo = new JButton("Go to one");

        add(buttonTwo);
        setBackground(Color.GREEN);

        buttonTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(panelCont, "1");
            }
        });

    }
}