import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Checkers2 extends JFrame {
    private static final int MAX_COUNT = 7;
    private final int ROWS = 2;
    private final int COLS = 5;
    private final int GAP = 2;
    private final int NUM = ROWS * COLS;
    private MyPanel2[] myPanels = new MyPanel2[NUM];

    public Checkers2() {
        super("Checkers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS, 1, 1));
        gridPanel.setBackground(Color.BLACK);
        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < myPanels.length; i++) {
            MyPanel2 myPanel = new MyPanel2(this);
            gridPanel.add(myPanel);
            myPanels[i] = myPanel;
        }

        JButton resetButton = new JButton("Reset");
        resetButton.setMnemonic(KeyEvent.VK_R);
        resetButton.addActionListener(evt -> {
            for (MyPanel2 myPanel2 : myPanels) {
                myPanel2.reset();
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_X);
        exitButton.addActionListener(evt -> System.exit(0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        add(gridPanel);
        add(buttonPanel, BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }

    public boolean isPanelDisabled() {
        int count = 0;
        for (MyPanel2 panel2 : myPanels) {
            if (panel2.isSelected()) {
                count++;
            }
        }
        return count >= MAX_COUNT;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Checkers2().setVisible(true);
        });
    }

}