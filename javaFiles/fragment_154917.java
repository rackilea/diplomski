import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

/**
 * @see https://stackoverflow.com/a/38934376/230513
 * @see https://stackoverflow.com/a/36392696/230513
 * @see https://stackoverflow.com/a/36243395/230513
 */
public class CardPanel extends JPanel {

    private static final JPanel cards = new JPanel(new CardLayout());
    private final String name;

    public CardPanel(String name, Coordinate coordinate) {
        super(new GridLayout());
        this.name = name;
        JMapViewer map = new JMapViewer() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        map.setDisplayPosition(coordinate, 12);
        this.add(map);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cards.add(new CardPanel("London", new Coordinate(51.5072, -0.1275)));
        cards.add(new CardPanel("Paris", new Coordinate(48.8566, 2.3522)));
        JPanel control = new JPanel();
        control.add(new JButton(new AbstractAction("\u22b2Prev") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.previous(cards);
            }
        }));
        control.add(new JButton(new AbstractAction("Next\u22b3") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.next(cards);
            }
        }));
        f.add(cards, BorderLayout.CENTER);
        f.add(control, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}