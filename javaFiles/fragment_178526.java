import javax.swing.*;

public class TransparentWindow extends JFrame 
{
    public TransparentWindow() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() 
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setOpacity(0.8f);
        setSize(200, 200);
        //System.setProperty("sun.java2d.noddraw", "true");
        //WindowUtils.setWindowTransparent(this, true);
        //WindowUtils.setWindowAlpha(this, 0.6f);
        setVisible(true);
        setVisible(false);

        JOptionPane.showMessageDialog(this, "It is working!", "Guess : ", JOptionPane.INFORMATION_MESSAGE); 
    }

    public static void main(String[] args) 
    {
        TransparentWindow tw = new TransparentWindow();
    }
}