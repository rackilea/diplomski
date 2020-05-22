import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingTest extends JFrame
{
    public void createUI()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        getContentPane().setLayout(new BorderLayout());
                        getContentPane().add(new JLabel("Quite a long text"), BorderLayout.CENTER);
                        getContentPane().add(new JLabel("Another text"), BorderLayout.CENTER);
                        pack();
                        setVisible(true);
                    }
                }
                );
    }

    public static void main(String ... args) 
    { 
        SwingTest st = new SwingTest();
        st.createUI();
    }
}