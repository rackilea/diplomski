import javax.swing.*;
import java.awt.*;

public class FrameSize {

    private JFrame frame;

    FrameSize create() {

        frame = createFrame();
        frame.getContentPane().add(createContent());

        return this;
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame(getClass().getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

    void show() {
        //   frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private Component createContent() {
        JPanel panel = new JPanel(null);

        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(Color.blue);
        topPanel.setBounds(0, 0, 500, 40);
        panel.add(topPanel);

        JPanel middlePanel = new JPanel(null);
        middlePanel.setBackground(Color.yellow);
        middlePanel.setBounds(0, 40, 500, 385);
        panel.add(middlePanel);

        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setBackground(Color.black);
        bottomPanel.setBounds(0, 425, 500, 75);
        panel.add(bottomPanel);

        panel.setPreferredSize(new Dimension(500, topPanel.getBounds().height + middlePanel.getBounds().height + bottomPanel.getBounds().height));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameSize().create().show();
            }
        });
    }
}