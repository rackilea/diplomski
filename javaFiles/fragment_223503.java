import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CardlayoutTest {

    private Color[] colors = new Color[]{Color.BLACK, Color.RED, Color.GREEN, Color.BLUE};
    private JFrame frame = new JFrame();
    private JList list = new JList();
    private JPanel panel = new JPanel();
    private CardLayout card = new CardLayout();

    public CardlayoutTest() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(card);
        Vector<String> items = new Vector<String>();
        for (int x = 0; x < colors.length; x++) {
            JPanel pnl = new JPanel(new BorderLayout());
            pnl.setBackground(colors[x]);
            panel.add(pnl, colors[x].toString());
            items.add(colors[x].toString());
        }
        list = new JList(items);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String card = list.getSelectedValue().toString();
                    CardLayout cL = (CardLayout) (panel.getLayout());
                    cL.show(panel, card);
                }
            }
        });
        frame.add(new JScrollPane(list), BorderLayout.WEST);
        frame.add(panel);
        frame.setPreferredSize(new Dimension(400, 150));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardlayoutTest();
            }
        });
    }
}