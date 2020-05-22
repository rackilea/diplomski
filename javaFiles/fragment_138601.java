import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SSCCE extends JPanel
{
    ArrayList<JLabel> cards = new ArrayList<JLabel>();

    public SSCCE()
    {
        setLayout( null );

        cards.add( createCard("1", Color.RED) );
        cards.add( createCard("2", Color.GREEN) );
        cards.add( createCard("3", Color.BLUE) );
        cards.add( createCard("4", Color.YELLOW) );

        //  This would be your first natural attempt (but it doesn't work)

        for (int i = 0; i < cards.size(); i++)
            add( cards.get(i) );

        //  This affects the Z-Order to do what you want

//      for (int i = 0; i < cards.size(); i++)
//          add(cards.get(i), 0);
    }

    public JLabel createCard(String text, Color background)
    {
        JLabel label = new JLabel(text);
        label.setOpaque( true );
        label.setBackground( background );
        label.setSize(30, 70);
        label.setLocation((cards.size() + 1) * 20 , 20);

        return label;
    }



    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SSCCE());
        frame.setLocationByPlatform( true );
        frame.setSize(200, 200);
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}