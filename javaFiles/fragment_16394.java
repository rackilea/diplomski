import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Scheduler {

    JButton VDay, VWeek, Task, Exit;
    JFrame wframe, dframe, tframe;

    JLabel head;

    public void CreateFrame() {
        JFrame frame = new JFrame("Main Menu");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = .25;
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        head = new JLabel("The Plain Scheduler");
        panel.add(head, c);
        VDay = new JButton("View Day");
        panel.add(VDay, c);
        VWeek = new JButton("View Week");
        panel.add(VWeek, c);
        Task = new JButton("Assign/Edit Tasks");
        panel.add(Task, c);
        Exit = new JButton("Exit");
        panel.add(Exit, c);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Scheduler scheduler = new Scheduler();
                scheduler.CreateFrame();
            }
        });
    }
}