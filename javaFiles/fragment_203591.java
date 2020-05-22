import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame {

    public MainFrame()
    {
        JFrame frame = new JFrame("Binary Clock");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setResizable(false);

        for(int i = 0; i < 5; i++)
        {
            JLabel label = new JLabel();
            label.setLocation(i * 10, i * 10);
            label.setSize(30, 10);
            label.setText("TEST");
            frame.add(label);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }
}