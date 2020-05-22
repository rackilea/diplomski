import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AgeOfEmpires implements Runnable {

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AgeOfEmpires());
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("Age of Empires");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createMainPanel());

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JPanel tilePanel = new JPanel();
        tilePanel.setBackground(Color.CYAN);
        tilePanel.setPreferredSize(new Dimension(800, 300));

        upperPanel.add(tilePanel);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JPanel miniMapPanel = new JPanel();
        miniMapPanel.setBackground(Color.BLUE);
        miniMapPanel.setPreferredSize(new Dimension(400, 300));

        JPanel unknownPanel = new JPanel();
        unknownPanel.setBackground(Color.GREEN);
        unknownPanel.setPreferredSize(new Dimension(400, 300));

        lowerPanel.add(miniMapPanel);
        lowerPanel.add(unknownPanel);

        mainPanel.add(upperPanel, BorderLayout.CENTER);
        mainPanel.add(lowerPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

}