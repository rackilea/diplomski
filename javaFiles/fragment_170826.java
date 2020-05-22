import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TempProject extends JPanel{

    public static void main(String args[])    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(300, 2000));
                JScrollPane pane = new JScrollPane(panel);
                pane.setPreferredSize(new Dimension(400, 300));
                pane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){

                    @Override
                    public void adjustmentValueChanged(AdjustmentEvent e) {
                        System.out.println("Hi Mom!");
                    }});

                frame.setContentPane(pane); 
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}