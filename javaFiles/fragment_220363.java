import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ViewportBackground
{
    private static void createAndShowUI()
    {
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setOpaque(false);

        JViewport viewport = new JViewport()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                int w = this.getWidth();
                int h = this.getHeight();
                g.setColor(new Color(0, 0, 255, 50));
                g.fillRect(0, 0, w/2, h/2);
                g.setColor(new Color(255, 0, 0, 50));
                g.fillRect(w/2, 0, w, h/2);
                g.setColor(new Color(0, 255, 0, 50));
                g.fillRect(0, h/2, w, h/2);
            }
        };

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);
        scrollPane.setViewportView( textArea );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( scrollPane );
        frame.setLocationByPlatform( true );
        frame.pack();
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