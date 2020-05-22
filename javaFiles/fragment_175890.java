import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TableTitle
{
    public TableTitle ()
    {
        JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel ();
        panel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                            "Table Title",
                                                            TitledBorder.CENTER,
                                                            TitledBorder.TOP));


        JTable table = new JTable (3, 3);

        panel.add (table);

        frame.add (panel);

        frame.setLocationRelativeTo (null);
        frame.pack ();
        frame.setVisible (true);
    }

    public static void main (String[] args)
    {
        SwingUtilities.invokeLater (new Runnable ()
        {
            @Override public void run ()
            {
                TableTitle t = new TableTitle ();
            }
        });
    }
}