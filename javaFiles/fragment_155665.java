package javaapplication659;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestCommand {

    public static void main(String[] args) {
        new TestCommand();
    }

    public TestCommand() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Map<String, Command> commands = new HashMap<>(25);
        private ActionListener actionListener;
        private GridBagConstraints gbc;

        public TestPane() {
            setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(1, 1, 1, 1);
            actionListener = new ActionHandler();
            add("Take over the world", new Command() {
                @Override
                public void execute() {
                    System.out.println("Take over the world");
                }
            });
            add("Quwell up rising", new Command() {
                @Override
                public void execute() {
                    System.out.println("Bring the boot down");
                }
            });
            add("Buy milk", new Command() {
                @Override
                public void execute() {
                    System.out.println("Buy milk");
                }
            });
        }

        public void add(String text, Command cmd) {
            JButton btn = new JButton(text);
            btn.addActionListener(actionListener);
            commands.put(text, cmd);
            add(btn, gbc);
        }

        public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Command cmd = commands.get(e.getActionCommand());
        if (cmd != null) {
            cmd.execute();
        }
    }

        }

    }

    public interface Command {
        public void execute();
    }
}