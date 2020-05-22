import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

    public static void main(String... s) {
        new TestFrame();
    }

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void init() {
        setLayout(new BorderLayout());

        JLabel head = new JLabel("Header");
        head.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel side = new JLabel("SideBar");
        side.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel changable = getPanel();
        changable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(head,BorderLayout.NORTH);
        add(side,BorderLayout.WEST);
        add(changable,BorderLayout.CENTER);
    }


    private JPanel getPanel() {
        final CardLayout cards = new CardLayout(5,5);
        final JPanel p = new JPanel(cards);
        p.add(new JLabel("1"), "1");
        p.add(new JLabel("2"), "2");

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cards.next(p);
            }
        });

        return p;
    }

}