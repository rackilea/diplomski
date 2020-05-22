import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateLabel extends JFrame
{
    private int count = 0;
    public UpdateLabel()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        final JLabel label = new JLabel("JLabel " + count);
        JButton button = new JButton("UPDATE JLABEL");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                count++;
                label.setText("JLabel " + count);
                contentPane.revalidate(); // sometimes you require to do this and the below line.
                contentPane.repaint();
            }
        });

        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.PAGE_END);

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    public static void main(String... args)
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                new UpdateLabel();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}