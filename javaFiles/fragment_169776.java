import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class OverPanel extends JPanel
{   
    private static void createAndShowGUI()
    {
        final JFrame f = new JFrame();
        f.setPreferredSize(new Dimension(400, 300));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        JPanel glassPanel = new JPanel();
        glassPanel.setBackground(Color.RED);        
        glassPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
                System.out.println("f.getGlassPane() mousePressed");
                if(e.getButton() == MouseEvent.BUTTON3)
                    f.getGlassPane().setVisible(false);
            }
        });
        f.setGlassPane(glassPanel);     

        f.getContentPane().setBackground(Color.GREEN);
        f.getContentPane().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
                System.out.println("f.getContentPane() mousePressed");
                if(e.getButton() == MouseEvent.BUTTON3)
                    f.getGlassPane().setVisible(true);
            }
        });
        f.getGlassPane().setVisible(true);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}