import java.awt.*;
import javax.swing.*;

public class GridBadFrame {

    private JFrame frame;
    private JPanel pnlCenter;
    private JPanel pnl1;
    private JPanel pnl2;
    private JPanel pnl3;

    public GridBadFrame() {
        pnl1 = new JPanel();
        pnl1.setBackground(Color.red);
        pnl2 = new JPanel();
        pnl2.setBackground(Color.blue);
        pnl3 = new JPanel();
        pnl3.setBackground(Color.red);
        JLabel lblWest = new JLabel();
        lblWest.setPreferredSize(new Dimension(50, 150));
        JLabel lblEast = new JLabel();
        lblEast.setPreferredSize(new Dimension(50, 150));
        JLabel lblNorth = new JLabel();
        lblNorth.setPreferredSize(new Dimension(600, 50));
        JLabel lblSouth = new JLabel();
        lblSouth.setPreferredSize(new Dimension(600, 50));
        pnlCenter = new JPanel();
        pnlCenter.setBackground(Color.black);
        pnlCenter.setLayout(new java.awt.GridLayout(3, 0, 10, 10));
        pnlCenter.setPreferredSize(new Dimension(600, 400));
        pnlCenter.add(pnl1);
        pnlCenter.add(pnl2);
        pnlCenter.add(pnl3);
        frame = new JFrame();
        frame.add(pnlCenter, BorderLayout.CENTER);
        frame.add(lblNorth, BorderLayout.NORTH);
        frame.add(lblSouth, BorderLayout.SOUTH);
        frame.add(lblWest, BorderLayout.WEST);
        frame.add(lblEast, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                GridBadFrame gridBadFrame = new GridBadFrame();
            }
        });
    }
}