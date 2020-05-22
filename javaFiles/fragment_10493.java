import java.awt.*;
import javax.swing.*;

public final class JButtonDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }


    private static void createAndShowGUI()
    {
        JButton button = new JButton();

        CompoundIcon icon = new CompoundIcon(CompoundIcon.Axis.Y_AXIS,
            new TextIcon(button, "Top Label"),
            UIManager.getIcon("OptionPane.informationIcon"),
            new TextIcon(button, "Bottom Label"));

        button.setIcon( icon );
        button.setFocusPainted( false );

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add( button );
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}