import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestColorFrame extends JFrame {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel Mainpanel = new JPanel(new GridLayout(2, 1));


        ColorPanel2 p1 = new ColorPanel2();
        ColorPanel1 p = new ColorPanel1(p1);

        //f.getContentPane().setLayout(new BorderLayout() );
        f.add(Mainpanel);

        Mainpanel.add(p);
        Mainpanel.add(p1, BorderLayout.SOUTH);

        f.setVisible(true);
        f.setResizable(false);
        f.setSize(500, 500);
        f.setTitle("My Color Frame");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ColorPanel1 extends JPanel implements
        AdjustmentListener, ChangeListener {
    private JLabel jLabelred, jLabelgreen, jLabelblue;

    public JScrollBar jRedScrollbar, jGreenScollbar, jBlueScrollbar;
    //private JTextField jRedtext,jGreentext,jBluetext;
    protected JSpinner jRed, jGreen, jBlue;
    ColorPanel2 colorPanel2;
    public Color current;

    public ColorPanel1(ColorPanel2 colorPanel2) {
        this.colorPanel2 = colorPanel2;
        setLayout(new GridLayout(3, 3, 60, 60));
        jLabelred = new JLabel("RED");
        add(jLabelred);

        SpinnerModel spinnerModel = new SpinnerNumberModel(100, 0, 255, 1);
        jRed = new JSpinner(spinnerModel);
        add(jRed);
        jRedScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 100, 40, 0, 255);
        add(jRedScrollbar);

        jLabelgreen = new JLabel("GREEN");
        add(jLabelgreen);
        SpinnerModel spinnerModel1 = new SpinnerNumberModel(200, 0, 255, 1);
        jGreen = new JSpinner(spinnerModel1);
        add(jGreen);

        jGreenScollbar = new JScrollBar(JScrollBar.HORIZONTAL, 200, 4, 0, 255);
        add(jGreenScollbar);

        jLabelblue = new JLabel("BLUE");
        add(jLabelblue);
        SpinnerModel spinnerModel2 = new SpinnerNumberModel(50, 0, 255, 1);
        jBlue = new JSpinner(spinnerModel2);
        add(jBlue);

        jBlueScrollbar = new JScrollBar(JScrollBar.HORIZONTAL, 50, 40, 0, 255);
        add(jBlueScrollbar);

        jRedScrollbar.addAdjustmentListener(this);
        jBlueScrollbar.addAdjustmentListener(this);
        jGreenScollbar.addAdjustmentListener(this);
        spinnerModel.addChangeListener(this);
        spinnerModel1.addChangeListener(this);
        spinnerModel2.addChangeListener(this);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        int r = jRedScrollbar.getValue();
        int g = jGreenScollbar.getValue();
        int b = jBlueScrollbar.getValue();

        jRed.setValue(jRedScrollbar.getValue());
        jBlue.setValue(jBlueScrollbar.getValue());
        jGreen.setValue(jGreenScollbar.getValue());
        setNewPanelColor();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        SpinnerModel spinnerModel = jRed.getModel();
        if (spinnerModel instanceof SpinnerModel) {
            jRedScrollbar.setValue((int) spinnerModel.getValue());
            setNewPanelColor();
        }
        SpinnerModel spinnerModel1 = jGreen.getModel();
        if (spinnerModel1 instanceof SpinnerModel) {
            jGreenScollbar.setValue((int) jGreen.getValue());
            setNewPanelColor();
        }
        SpinnerModel spinnerModel2 = jBlue.getModel();
        if (spinnerModel2 instanceof SpinnerModel) {
            jBlueScrollbar.setValue((int) jBlue.getValue());
            setNewPanelColor();
        }
    }

    public void setNewPanelColor() {
        int r = (int)((SpinnerModel)jRed.getModel()).getValue();
        int g = (int)((SpinnerModel)jGreen.getModel()).getValue();
        int b = (int)((SpinnerModel)jBlue.getModel()).getValue();
        colorPanel2.setColor(new Color(r, g, b));
    }
}

class ColorPanel2 extends JPanel {

    private JColorChooser colorchooser;
    private Color color = new Color(100, 200, 50);

    public ColorPanel2() {
        setLayout(new BorderLayout());
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(color);
        graphics.fillRect(100, 50, 300, 150);
    }
}