import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class JavaApplication78 {

    JFrame frame;
    JPanel panel, labelsPanel;
    JLabel label;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<JLabel> labelsArray = new ArrayList<JLabel>();
    Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    Border border = BorderFactory.createLineBorder(Color.BLUE);
    JScrollPane labelsScroll;

    public JavaApplication78() {
        frame = new JFrame();
        panel = new JPanel(new BorderLayout());
        names.add(".mp3");
        names.add(".html");
        names.add(".jpeg");
        names.add(".mp4");
        names.add(".pdf");

        labelsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        labelsScroll = new JScrollPane(labelsPanel);
        for (String format : names) {
            label = new JLabel(format);
            //icon
            labelsArray.add(label);
            labelsPanel.add(label, gbc);
            label.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
        }

        panel.add(labelsScroll, BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(200, 400);
        frame.setLocationRelativeTo(null);
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

                new JavaApplication78();
            }
        });
    }
}