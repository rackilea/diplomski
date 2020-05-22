import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TitledBorderTest
{
    private static void createAndShowUI()
    {
        UIManager.getDefaults().put("TitledBorder.titleColor", Color.RED);
        Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Title");
//      title.setTitleJustification(TitledBorder.RIGHT);
        Font titleFont = UIManager.getFont("TitledBorder.font");
        title.setTitleFont( titleFont.deriveFont(Font.ITALIC + Font.BOLD) );

        JPanel panel = new JPanel()
        {
            @Override
            public String getToolTipText(MouseEvent e)
            {
                Border border = getBorder();

                if (border instanceof TitledBorder)
                {
                    TitledBorder tb = (TitledBorder)border;
                    FontMetrics fm = getFontMetrics( tb.getTitleFont() );
                    int titleWidth = fm.stringWidth(tb.getTitle()) + 20;
                    Rectangle bounds = new Rectangle(0, 0, titleWidth, fm.getHeight());
                    return bounds.contains(e.getPoint()) ? super.getToolTipText() : null;
                }

                return super.getToolTipText(e);
            }
        };
        panel.setBorder( title );
        panel.setToolTipText("Title With ToolTip");

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
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