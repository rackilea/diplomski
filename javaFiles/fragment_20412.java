import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GuesGame implements Runnable {
    private JFrame frame;

    public void run() {
        showGui();
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(createSubmitPanel());
        bottomPanel.add(createKeyboardPanel());
        bottomPanel.add(createButtonsPanel());
        return bottomPanel;
    }

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        JButton startButton = new JButton("Start");
        buttonsPanel.add(startButton);
        JButton nextButton = new JButton("Next");
        buttonsPanel.add(nextButton);
        JButton skipButton = new JButton("Skip");
        buttonsPanel.add(skipButton);
        JButton quitButton = new JButton("Quit");
        buttonsPanel.add(quitButton);
        return buttonsPanel;
    }

    private JPanel createKeyboardPanel() {
        JPanel keyboardPanel = new JPanel(new GridLayout(2, 13));
        for (char c = 'a'; c <= 'z'; c++) {
            JButton button = new JButton(String.valueOf(c));
            keyboardPanel.add(button);
        }
        return keyboardPanel;
    }

    private JPanel createSubmitPanel() {
        JPanel submitPanel = new JPanel();
        JTextField txtFld = new JTextField(20);
        submitPanel.add(txtFld);
        JButton submitButton = new JButton("Submit");
        submitPanel.add(submitButton);
        return submitPanel;
    }

    private void showGui() {
        frame = new JFrame("Guess Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new Display(), BorderLayout.CENTER);
        frame.add(createBottomPanel(), BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new GuesGame());
    }
}

class Display extends JPanel {
    private String message;

    Display() {
        message = "Starting game";
        setPreferredSize(new Dimension(620, 420));
        setBackground(new Color(250, 230, 180));
        setFont(new Font("Serif", Font.BOLD, 20));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        if (message != null) {
            g.setColor(Color.RED);
            g.drawString(message, 30, 40);
            g.drawString("00:00", 30, 410);
        }
    }
}