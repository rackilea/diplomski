import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollingExample extends JFrame
{
    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        ScrollingExample scrollingExample = new ScrollingExample();
        scrollingExample.go();
    }

    private void go()
    {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("boo"));

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel mainInnerPanel = makeMainInnerPanel();

        JScrollPane scrollPane = new JScrollPane(mainInnerPanel);
        mainPanel.add(scrollPane);
        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private JPanel makeMainInnerPanel()
    {
        JPanel row1 = makeHorizontalPanel("one", "two", "three", "four", "five");
        JPanel row2 = makeHorizontalPanel("six", "seven", "eight");
        JPanel row3 = makeHorizontalPanel("nine", "ten", "eleven");
        JPanel mainInnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainInnerPanel.add(row1);
        mainInnerPanel.add(row2);
        mainInnerPanel.add(row3);
        return mainInnerPanel;
    }

    private JPanel makeHorizontalPanel(String ... labelValues)
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (String s : labelValues)
        {
            JLabel label = new JLabel(s);
            panel.add(label);
        }
        return panel;
    }
}