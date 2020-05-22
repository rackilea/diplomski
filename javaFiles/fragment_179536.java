import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class HelpOutput extends JFrame
{
    private static final long   serialVersionUID    = -1323914827861467580L;
    private JScrollPane         scrPnl;
    private JTextArea           txaOutput;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                btnHelpActionPerformed(null);
            }
        });
    }

    public HelpOutput()
    {

        scrPnl = new JScrollPane();
        txaOutput = new JTextArea();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        scrPnl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrPnl.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrPnl.setViewportBorder(BorderFactory.createEtchedBorder());
        scrPnl.setAutoscrolls(false);
        scrPnl.setPreferredSize(new Dimension(500, 555));

        txaOutput.setFont(new Font("Courier New", 0, 14));
        scrPnl.setViewportView(txaOutput);

        setLayout(new BorderLayout());

        add(scrPnl, BorderLayout.CENTER);

        setVisible(true);
        pack();
    }

    public void appendHelp(String s)
    {
        txaOutput.append(s);
    }

    public void putCarrotAtTop()
    {
        txaOutput.setCaretPosition(0);
    }

    private static void btnHelpActionPerformed(ActionEvent evt)
    {
        HelpOutput helpOutput = new HelpOutput();

        helpOutput
                .appendHelp("Lots of help\nLots of help\nLots of help\nLots of help\nLots of help\n");
        helpOutput.putCarrotAtTop();
    }
}