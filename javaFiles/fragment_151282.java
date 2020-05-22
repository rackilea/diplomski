import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ItssRectangle extends JPanel {
    private static final String RECTANGLE = "Rectangle";
    private static final String OVAL = "Oval";
    private static final String[] SHAPES = { RECTANGLE, OVAL };
    private static final int PREF_W = 400;
    private static final int PREF_H = 250;
    private String shapeText = "";
    private ButtonGroup buttonGroup = new ButtonGroup();

    public ItssRectangle() {
        RadioBtnListener radioBtnListener = new RadioBtnListener();
        JPanel panel = new JPanel();
        for (String shape : SHAPES) {
            JRadioButton rBtn = new JRadioButton(shape);
            rBtn.setOpaque(false);
            rBtn.setActionCommand(shape);
            rBtn.addActionListener(radioBtnListener);
            panel.add(rBtn);
            buttonGroup.add(rBtn);
        }

        panel.setOpaque(false);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (RECTANGLE.equals(shapeText)) {
            g.setColor(Color.BLUE);
            g.fillRect(25, 25, 150, 50); // TODO: Get rid of magic numbers
        } else if (OVAL.equals(shapeText)) {
            g.setColor(Color.RED);
            g.fillOval(25, 80, 100, 100); // TODO: Ditto!
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class RadioBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shapeText = e.getActionCommand();
            repaint();
        }
    }

    private static void createAndShowGui() {
        ItssRectangle mainPanel = new ItssRectangle();

        JFrame frame = new JFrame("ItssRectangle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}