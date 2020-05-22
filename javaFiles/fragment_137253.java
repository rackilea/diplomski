package example.stackoverflow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ClickCheck extends JFrame
{
    private static final long serialVersionUID = -6446528001976145548L;
    private static final JButton btnOpenLog = new JButton("Open Log");
    public ClickCheck()
    {
        JLabel label = new JLabel("Double-Click Me");
        label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    btnOpenLog.doClick();
                }
            }
        });

        // Uncomment to demonstrate the effect of multiple listeners
//        label.addMouseListener(new MouseAdapter()
//        {
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//                if (arg0.getClickCount() == 2) {
//                    btnOpenLog.doClick();
//                }
//            }
//        });

        btnOpenLog.addActionListener(new ActionListener() {
            private int clickCount = 0;
            public void actionPerformed(ActionEvent e) {
                    System.out.println(++clickCount + ": Button clicked");
                }
            });


        setSize(200, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(btnOpenLog);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                ClickCheck c = new ClickCheck();
                c.setVisible(true);
            }
        });
    }
}