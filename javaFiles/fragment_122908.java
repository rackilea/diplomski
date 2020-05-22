import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ChatPanel chatPane = new ChatPanel();

                HelloAction action = new HelloAction(chatPane);
                Toolbar toolBar = new Toolbar();
                toolBar.addAction(action);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(toolBar, BorderLayout.NORTH);
                frame.add(chatPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Toolbar extends JPanel {

        public void addAction(Action action) {
            add(new JButton(action));
        }

    }

    public class OutletAction extends AbstractAction {

        private Outlet outlet;
        private String text;

        public OutletAction(Outlet outlet, String text) {
            this.outlet = outlet;
            this.text = text;
        }

        public Outlet getOutlet() {
            return outlet;
        }

        public String getText() {
            return text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getOutlet().say(getText());
        }
    }

    public class HelloAction extends OutletAction {

        public HelloAction(Outlet outlet) {
            super(outlet, "Hello");
            putValue(Action.NAME, "Hello");
            //putValue(Action.SMALL_ICON, icon);
        }
    }

    public interface Outlet {

        public void say(String text);

    }

    public class ChatPanel extends JPanel implements Outlet {

        private JLabel nameLabel;
        private JTextField chatField;
        private JTextArea chatArea;
        private GridBagConstraints gc;

        private static final String NEWLINE = "\n";

        public ChatPanel() {
            super(new GridBagLayout());

            //chatArea
            chatArea = new JTextArea(8, 30);
            chatArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(chatArea);
            gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 0;
            add(scrollPane, gc);

            //nameLabel
            nameLabel = new JLabel("Name: ");
            gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 2;
            gc.anchor = GridBagConstraints.LINE_START;
            gc.weightx = 0.0;
            add(nameLabel, gc);

            //chatField
            chatField = new JTextField(25);
            chatField.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = chatField.getText() + NEWLINE;
                    chatArea.append(message);
                    chatField.setText("");
                }

            });
            gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 2;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.weightx = 0.0;
            add(chatField, gc);

        }

        @Override
        public void say(String text) {
            chatArea.append(text + NEWLINE);
        }

    }
}