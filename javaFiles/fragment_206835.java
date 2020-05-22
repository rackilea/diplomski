import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** @see http://stackoverflow.com/a/14947144/230513 */
public class Test {

    private JButton button = new JButton("Update");

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createPanel(button), BorderLayout.NORTH);
        f.add(createPanel(button), BorderLayout.WEST);
        f.add(createPanel(button), BorderLayout.EAST);
        f.add(createPanel(button), BorderLayout.SOUTH);
        JPanel p = new JPanel();
        p.add(button);
        f.add(p, BorderLayout.CENTER);
        f.getRootPane().setDefaultButton(button);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JPanel createPanel(JButton b) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final JTextField text = new JTextField();
        b.addActionListener(new UpdateHandler(text));
        panel.add(text);
        return panel;
    }

    private static class UpdateHandler extends AbstractAction {

        private JTextField text;
        private DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");

        public UpdateHandler(JTextField t) {
            super("update");
            t.setText(df.format(new Date()));
            this.text = t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            text.setText(df.format(new Date()));
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}