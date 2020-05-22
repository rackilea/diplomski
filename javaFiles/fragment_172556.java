import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.net.*;

public class ImageReload extends JPanel implements ActionListener
{
    JLabel timeLabel;
    JLabel imageLabel;
    ImageIcon icon = new ImageIcon("timeLabel.jpg");

    public ImageReload()
    {
        setLayout( new BorderLayout() );

        timeLabel = new JLabel( new Date().toString() );
        imageLabel = new JLabel( timeLabel.getText() );

        add(timeLabel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.SOUTH);

        javax.swing.Timer timer = new javax.swing.Timer(1000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e)
    {
        timeLabel.setText( new Date().toString() );

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    String imageName = "timeLabel.jpg";
                    BufferedImage image = ScreenImage.createImage(timeLabel);
                    ScreenImage.writeImage(image, imageName);

                    //  This works using ImageIO

                    imageLabel.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );

                    //  Or you can flush the image
/*
                    ImageIcon icon = new ImageIcon(imageName);
                    icon.getImage().flush();
                    imageLabel.setIcon( icon );
*/
                    imageLabel.setText("");
                }
                catch(Exception e)
                {
                    System.out.println( e );
                }
            }
        });
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new ImageReload() );
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