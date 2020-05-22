import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TitleTestFrame extends JFrame
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TitleTestFrame();
            }
        });
    }

    public TitleTestFrame()
    {
        super("frame title");

        JLabel titleLabel = new JLabel("This is a centered title.");
        JLabel subtitleLabel = new JLabel("Subtitle");

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0; //all components in the row with weightx = 0.0 keeps the components clump together in the center.
                           //This way the labels will be in the center of the panel.

        c.anchor = GridBagConstraints.FIRST_LINE_START; //FIRST_LINE makes the title and subtitle stay at the top of the frame.
                          //LINE_START make them be glued to the beginning of its column. However because the weightx = 0.0 the column is centered.


        mainPanel.add(titleLabel,  c);
        c.gridy = 1;
        c.weighty = 1.0;  // this weight must be put in the components under the titles so they don't get far from each other.
        mainPanel.add(subtitleLabel, c);


        add(mainPanel);

        setSize(new Dimension(400,300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}