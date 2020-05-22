import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class ResizingSplitPane extends JFrame implements ActionListener
{

    private JButton clickMe;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JSplitPane split;

    // private int dividerLocation;

    public ResizingSplitPane()
    {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Center Panel
        clickMe = new JButton("Click Me!!");
        clickMe.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(clickMe);

        // Bottom Panel
        leftPanel = new JPanel(new BorderLayout());
        rightPanel = new JPanel(new BorderLayout());

        leftPanel.add(new JLabel("Left"), BorderLayout.CENTER);
        rightPanel.add(new JLabel("Right"), BorderLayout.CENTER);

        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        split.setResizeWeight(.5d);

        add(panel, BorderLayout.PAGE_START);
        add(split, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ResizingSplitPane();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == clickMe)
        {
            if (split.getRightComponent().isVisible())
            {
                // dividerLocation = split.getDividerLocation();
                split.getRightComponent().setVisible(false);
            }
            else
            {
                split.getRightComponent().setVisible(true);
                split.setDividerLocation(0.5);
            }
        }
    }

}