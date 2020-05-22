import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Checkers3 extends JPanel {
    private static final int MAX_COUNT = 7;
    private final int ROWS = 2;
    private final int COLS = 5;
    private final int GAP = 2;
    private final int NUM = ROWS * COLS;
    private MyPanel3[] myPanels = new MyPanel3[NUM];

    public Checkers3() {
        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS, 1, 1));
        gridPanel.setBackground(Color.BLACK);
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        MyMouse myMouse = new MyMouse();
        for (int i = 0; i < myPanels.length; i++) {
            MyPanel3 myPanel = new MyPanel3();
            myPanel.addMouseListener(myMouse);
            gridPanel.add(myPanel);
            myPanels[i] = myPanel;
        }

        JButton resetButton = new JButton("Reset");
        resetButton.setMnemonic(KeyEvent.VK_R);
        resetButton.addActionListener(evt -> {
            for (MyPanel3 myPanel : myPanels) {
                myPanel.reset();
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_X);
        exitButton.addActionListener(evt -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        setLayout(new BorderLayout());
        add(gridPanel);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    public boolean isPanelDisabled() {
        int count = 0;
        for (MyPanel3 panel : myPanels) {
            if (panel.isSelected()) {
                count++;
            }
        }
        return count >= MAX_COUNT;
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            MyPanel3 myPanel = (MyPanel3) e.getSource();
            if (myPanel.isSelected()) {
                return; // it's already selected
            } else if (isPanelDisabled()) {
                myPanel.setSelected(false);
            } else {
                myPanel.setSelected(true);
            }
        }
    }

    private static void createAndShowGui() {
        Checkers3 mainPanel = new Checkers3();

        JFrame frame = new JFrame("Checkers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}