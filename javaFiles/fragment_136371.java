import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

import javax.swing.*;

// main GUI JPanel that holds the light drawing JPanel as well as the buttons
@SuppressWarnings("serial")
public class TrafficLightPanel2 extends JPanel {
    private static final int LIGHT_SIZE = 200; // size of the circle
    private static final int GAP = 10; // border gap around the jpanel

    // the Jlight drawing JPanel that draws the circles
    private LightDrawingPanel lightDrawingPanel = new LightDrawingPanel(null, LIGHT_SIZE);

    public TrafficLightPanel2() {
        // JPanel to hold the buttons, 1 row, variable number of columns, gap between buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
        for (LightColor lightColor : LightColor.values()) {
            // create each button within the loop, giving it an Action -- an ActionListener "on steroids"
            buttonPanel.add(new JButton(new LightColorAction(lightColor, lightDrawingPanel)));
        }

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BorderLayout(GAP, GAP));
        add(lightDrawingPanel, BorderLayout.CENTER);  // add the light drawer to the center
        add(buttonPanel, BorderLayout.PAGE_END);  // and the buttons to the bottom
    }

    private static void createAndShowGui() {
        TrafficLightPanel2 mainPanel = new TrafficLightPanel2();

        JFrame frame = new JFrame("Traffic Light");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();  // have layout managers do their thing
        frame.setLocationRelativeTo(null); // center
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

// just acts as a class that connects a Color with a String
enum LightColor {
    RED(Color.RED, "Red"), YELLOW(Color.YELLOW, "Yellow"), GREEN(Color.GREEN, "Green");

    private LightColor(Color color, String text) {
        this.color = color;
        this.text = text;
    }
    private Color color;
    private String text;

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}

// create a class that only draws the circle, and that's it
@SuppressWarnings("serial")
class LightDrawingPanel extends JPanel {
    private Color color;
    private int size;

    public LightDrawingPanel(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // again, the super must be called

        // if no color defined, get out of here
        if (color == null) {
            return;
        }

        g.setColor(color);

        // make for smooth rendering 
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // center the circle
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        g2.fillOval(x, y, size, size);
    }

    // make our JPanel at least as large as the circle
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(size, size);
    }
}

// AbstractAction for our buttons
// like an ActionListener "on steroids"
@SuppressWarnings("serial")
class LightColorAction extends AbstractAction {
    private LightColor lightColor;
    private LightDrawingPanel lightDrawingPanel;

    public LightColorAction(LightColor lightColor, LightDrawingPanel lightDrawingPanel) {
        super(lightColor.getText());  // text for the button to show

        // initialize our fields
        this.lightColor = lightColor;
        this.lightDrawingPanel = lightDrawingPanel;

        // alt-key mnemonic derived from the text String
        int mnemonic = (int) lightColor.getText().charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // set the color of the drawing panel
        lightDrawingPanel.setColor(lightColor.getColor());
    }
}