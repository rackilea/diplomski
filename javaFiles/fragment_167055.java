import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout.Divider;
import org.jdesktop.swingx.MultiSplitLayout.Leaf;
import org.jdesktop.swingx.MultiSplitLayout.Split;

public class JXMultiSplitPaneTest extends JPanel
{
    private static final long serialVersionUID = 1L;

    public JXMultiSplitPaneTest()
    {
        //Simple case: creates a split pane with three compartments
        JXMultiSplitPane sp = new JXMultiSplitPane();
        JPanel p1 = new JPanel();
        p1.setBackground(Color.PINK);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.YELLOW);
        JPanel p3 = new JPanel();
        p3.setBackground(Color.CYAN);
        JPanel p4 = new JPanel();
        p4.setBackground(Color.RED);
        JPanel p5 = new JPanel();
        p5.setBackground(Color.BLUE);

        sp.setModel(new FiveHorizontalSplitPaneModel(true));
        sp.add(p1, FiveHorizontalSplitPaneModel.P1);
        sp.add(p2, FiveHorizontalSplitPaneModel.P2);
        sp.add(p3, FiveHorizontalSplitPaneModel.P3);
        sp.add(p4, FiveHorizontalSplitPaneModel.P4);
        sp.add(p5, FiveHorizontalSplitPaneModel.P5);

        setLayout(new BorderLayout());
        add(sp);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JXMultiSplitPaneTest p = new JXMultiSplitPaneTest();
                JFrame f = new JFrame();
                f.setContentPane(p);
                f.setSize(800, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}

class FiveHorizontalSplitPaneModel extends Split
{
    //5 possible positions
    public static final String P1 = "1";
    public static final String P2 = "2";
    public static final String P3 = "3";
    public static final String P4 = "4";
    public static final String P5 = "5";

    public FiveHorizontalSplitPaneModel()
    {
        this(false);
    }

    public FiveHorizontalSplitPaneModel(boolean isEqualyWeighted)
    {
        setRowLayout(true);
        Leaf p1 = new Leaf(P1);
        Leaf p2 = new Leaf(P2);
        Leaf p3 = new Leaf(P3);
        Leaf p4 = new Leaf(P4);
        Leaf p5 = new Leaf(P5);
        if(isEqualyWeighted)
        {
            p1.setWeight(0.2);
            p2.setWeight(0.2);
            p3.setWeight(0.2);
            p4.setWeight(0.2);
            p5.setWeight(0.2);
        }
        setChildren(p1, new Divider(), p2, new Divider(),
                p3, new Divider(), p4, new Divider(), p5);
    }
}