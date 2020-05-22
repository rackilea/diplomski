import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel {

    private JLayeredPane pane;
    private JPanel players; //Larger panel, uses circleLayout
    private JPanel game; //Smaller panel, simple BorderLayout

    public MainPanel() {
        super();
//        setSize(900, 900);
//        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setLayout(new BorderLayout());

        pane = new JLayeredPane();
//        pane.setPreferredSize(new Dimension(900, 900));
        pane.setBorder(new LineBorder(Color.RED));

        players = new JPanel();
        players.setBackground(Color.RED);
        players.setSize(getPreferredSize());
        players.setLocation(0, 0);
        //players.setOpaque(false);
        pane.add(players, new Integer(0));

        game = new JPanel();
        game.setSize(game.getPreferredSize());
        game.setBackground(Color.BLUE);
        game.setLocation(385, 405);
        //game.setOpaque(false);        
        pane.add(game, new Integer(2));

        add(pane);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(900, 900);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JComponent newPane = new MainPanel();
        newPane.setOpaque(true);
        frame.setContentPane(newPane);
        frame.pack();
        frame.setVisible(true);
    }
}