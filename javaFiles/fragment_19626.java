import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ScrollPaneDemo extends JFrame {
    public static void main(String[] args) {
        new ScrollPaneDemo();
    }

    public ScrollPaneDemo() {
        super("ScrollPaneExample");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JEditorPane editorPane = new JEditorPane("text/plain", "") {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(200, 200);
            }
        };
        editorPane.setBackground(Color.YELLOW);

        for (int i = 0; i < 50; i++) {
            editorPane.setText(editorPane.getText()
                    + "Hello World Hello World\n");
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);

        add(scrollPane);

        setVisible(true);
    }
}