import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.ease.Spline;

public class ButtonFg extends JFrame {

    private JScrollPane jsp;

    public ButtonFg() {
        JButton button = new JButton("sample");
        button.setForeground(Color.blue);

        JPanel panel = new JPanel(new GridBagLayout());
        this.add(panel);

        String s = UUID.randomUUID().toString();
        for (int i = 0; i < 20; i++) {
            s += "\n" + UUID.randomUUID().toString();

        }
        final JTextArea textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        jsp = new JScrollPane(textArea);

        final JButton label = new JButton("Show details...");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(label, gbc);

        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        panel.add(jsp, gbc);

        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        panel.add(new JLabel("End of panel"), gbc);

        final Timeline rolloverTimeline = new Timeline(this);
        rolloverTimeline.addPropertyToInterpolate("animate", new Dimension(400, 15), new Dimension(400, 200));
        rolloverTimeline.setEase(new Spline(0.8f));

        rolloverTimeline.setDuration(1000);
        rolloverTimeline.setInitialDelay(50);

        label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.getText().toLowerCase().contains("show")) {
                    rolloverTimeline.play();
                    label.setText("Hide details...");
                } else {
                    rolloverTimeline.playReverse();
                    label.setText("Show details...");
                }
            }

        });

        rolloverTimeline.playReverse();

        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setAnimate(Dimension size) {
        jsp.setPreferredSize(size);
        jsp.getParent().revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonFg().setVisible(true);
            }

        });
    }

}