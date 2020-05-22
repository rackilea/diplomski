import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TestDrawingPanel extends JPanel {
    private JButton addRectButton = new JButton("Add Rectangle");
    private JButton addSquareButton = new JButton("Add Square");
    private JButton addCircleButton = new JButton("Add Circle");
    private JButton clearButton = new JButton("Clear");

    private DrawingPanel drawingPanel = new DrawingPanel();

    public TestDrawingPanel() {
        // add ActionListeners
        addRectButton.addActionListener(evt -> addRectangle());
        addSquareButton.addActionListener(evt -> addSquare());
        addCircleButton.addActionListener(evt -> addCircle());
        clearButton.addActionListener(evt -> clear());
        JButton[] btns = { addRectButton, addSquareButton, addCircleButton, clearButton };

        // jpanel uses grid layout with one row and variable number of columns
        // and add all buttons to it
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 3, 3));
        for (JButton btn : btns) {
            buttonPanel.add(btn);
        }

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // blank border
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.PAGE_START); // add button panel to the top
        add(drawingPanel, BorderLayout.CENTER);  // add drawing panel to the center
    }

    private void addRectangle() {
        drawingPanel.setDrawRect(true);  // tell the drawing panel to draw the rectangle
    }

    private void addSquare() {
        // TODO: implement        
    }

    private void addCircle() {
        // TODO: implement
    }

    private void clear() {
        drawingPanel.setDrawRect(false);
        // TODO: complete
    }

    private static void createAndShowGui() {
        TestDrawingPanel mainPanel = new TestDrawingPanel();

        JFrame frame = new JFrame("Paint Program");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

}

// class addRect extends JPanel {
class DrawingPanel extends JPanel {
    // size information
    private static final int PREF_W = 300;
    private static final int PREF_H = PREF_W;
    private boolean drawRect = false;  // use this to decide if should draw rectangle or not

    public DrawingPanel() {
        setBorder(BorderFactory.createTitledBorder("Drawing Panel"));
    }

    // allow outside classes to set the drawRect field
    public void setDrawRect(boolean drawRect) {
        this.drawRect = drawRect;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // if true, draw the rectang.e
        if (drawRect) {
            g.setColor(Color.BLUE);
            g.fillRect(50, 30, 200, 100);
        }

        // TODO: complete rest
    }

    // So that the drawing JPanel will size appropriately
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
}