import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Main {
    private static void prepare(final JScrollPane scroll) {
        scroll.getViewport().getView().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(final FocusEvent e) {
                scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }

            @Override
            public void focusLost(final FocusEvent e) {
                scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            }
        });
    }

    public static void main(final String[] args) {
        final JTextArea area = new JTextArea("Type your messages here...");

        final JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(400, 100));

        prepare(scroll);

        final JPanel components = new JPanel();
        components.add(new JButton("Click me to change focus!"));
        components.add(scroll);

        final JFrame frame = new JFrame("Scroll auto focus.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(components);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}