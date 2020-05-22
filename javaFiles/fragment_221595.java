import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TestColorFrame {

    private static final int DEFAULT_VALUE = 100;

    private JSpinner rSpinner;
    private JSpinner gSpinner;
    private JSpinner bSpinner;
    private ColorPanel colorPanel;

    public TestColorFrame() {
        colorPanel = new ColorPanel();

        rSpinner = createRGBSpinner();
        gSpinner = createRGBSpinner();
        bSpinner = createRGBSpinner();

        JPanel spinnerPanel = new JPanel();
        spinnerPanel.add(new JLabel("R"));
        spinnerPanel.add(rSpinner);
        spinnerPanel.add(new JLabel("G"));
        spinnerPanel.add(gSpinner);
        spinnerPanel.add(new JLabel("B"));
        spinnerPanel.add(bSpinner);

        JFrame frame = new JFrame("Color Spinners");
        frame.add(colorPanel);
        frame.add(spinnerPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private JSpinner createRGBSpinner() {
        SpinnerNumberModel model = new SpinnerNumberModel(DEFAULT_VALUE, 0, 255, 1);
        JSpinner spinner = new JSpinner(model);
        spinner.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int[] values =  getModelValues();
                colorPanel.setColor(new Color(values[0], values[1], values[2]));
            }
        });
        return spinner;
    }

    private int[] getModelValues() {
        int r = (Integer)((SpinnerNumberModel)rSpinner.getModel()).getValue();
        int g = (Integer)((SpinnerNumberModel)gSpinner.getModel()).getValue();
        int b = (Integer)((SpinnerNumberModel)bSpinner.getModel()).getValue();
        return new int[] {r, g, b};
    }

    class ColorPanel extends JPanel {
        private Color color = new Color(DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestColorFrame();
            }
        });
    }
}