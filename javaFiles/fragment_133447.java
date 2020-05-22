import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class SplitPaneDividerAction extends AbstractAction
{
    private boolean leading;

    public SplitPaneDividerAction(boolean leading)
    {
        this.leading = leading;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JSplitPane splitPane = (JSplitPane)e.getSource();
        BasicSplitPaneUI ui = (BasicSplitPaneUI)splitPane.getUI();
        BasicSplitPaneDivider divider = ui.getDivider();

        if (leading)
            ((JButton)divider.getComponent(0)).doClick();
        else
            ((JButton)divider.getComponent(1)).doClick();
    }

    private static void createAndShowUI()
    {
        JPanel leading = new JPanel();
        leading.setPreferredSize( new Dimension(200, 100) );
        leading.setBackground( Color.BLUE );
        leading.setFocusable(true);

        JPanel trailing = new JPanel();
        trailing.setPreferredSize( new Dimension(200, 100) );
        trailing.setBackground( Color.RED );
        trailing.setFocusable(true);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leading, trailing);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(100);

        InputMap im = splitPane.getInputMap(JSplitPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap am = splitPane.getActionMap();
        im.put(KeyStroke.getKeyStroke("control U"), "leading");
        im.put(KeyStroke.getKeyStroke("control D"), "trailing");
        am.put("leading", new SplitPaneDividerAction(true));
        am.put("trailing", new SplitPaneDividerAction(false));

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( splitPane );
        frame.setSize(200, 200);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}