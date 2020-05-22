import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ScrollPaneExample extends JFrame {
    public static void main(String[] args) {
        new ScrollPaneExample();
    }
    public ScrollPaneExample() {
        super("ScrollPaneExample");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //getContentPane().setBackground(Color.BLUE);

        final JEditorPane editorPane = new JEditorPane("text/plain", "") {
        };

        editorPane.setBackground(Color.YELLOW);

        for (int i = 0; i < 5; i++)
            editorPane.setText(editorPane.getText() + "Hello World\n");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        contentPane.setBackground(Color.BLUE);
        contentPane.add(editorPane, gbc);

        gbc.gridy++;
        contentPane.add(new JButton("Button"), gbc);
        gbc.gridy++;
        contentPane.add(new JButton("Button"), gbc);

        JPanel panel = new JPanel();
        panel.add(contentPane);
        JScrollPane scrollPane = new JScrollPane(panel);

        add(scrollPane);

        setVisible(true);

        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                editorPane.setText(editorPane.getText() + "Hello World\n");
                setVisible(true);
            }
        });
        timer.start();
    }
}