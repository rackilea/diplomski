import java.awt.GridLayout;
import javax.swing.*;

public class StartupPanel {

    private JComponent getStartupPanel()
    {
        JPanel startup = new JPanel();
        startup.setLayout(new GridLayout(2,2,50,5));
        JButton addMember = new JButton("Add a new member");
        JButton removeMember = new JButton("remove Member");
        JButton reviewMember = new JButton("Review a Member");
        JButton reviewAll = new JButton("Review All Members");
        startup.add(addMember);
        startup.add(removeMember);
        startup.add(reviewMember);
        startup.add(reviewAll);

        return startup;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartupPanel sp = new StartupPanel();
                JOptionPane.showMessageDialog(null, sp.getStartupPanel());
            }
        });
    }
}