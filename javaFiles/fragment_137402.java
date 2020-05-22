import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame {

    private LinesModel lineModel;
    private PaintPanel paintPanel;
    private PanelWithButtons panelWithButtons;

    public Frame() {
        lineModel = new LinesModel();
        paintPanel = new PaintPanel();
        panelWithButtons = new PanelWithButtons(lineModel);

        lineModel.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String prop = evt.getPropertyName();
                if (LinesModel.LINES_PROPERTY.equals(prop)) {
                    paintPanel.repaint();
                }
            }   
        });

        add(paintPanel);
        add(panelWithButtons, BorderLayout.SOUTH);

        setTitle("MVC Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public class PaintPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int y = 50;
            for (int i = 0; i < lineModel.getLines(); i++) {
                g.drawLine(50, y, 200, y);
                y += 20;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Frame();
            }
        });
    }
}


class PanelWithButtons extends JPanel {

    private final JButton fourLines = new JButton("FOUR");
    private final JButton fiveLines = new JButton("FIVE");
    private LinesModel lineModel;

    public PanelWithButtons(LinesModel lineModel) {
        this.lineModel = lineModel;

        fiveLines.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelWithButtons.this.lineModel.setLines(4);
            }
        });

        fourLines.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelWithButtons.this.lineModel.setLines(5);
            }
        });

        add(fourLines);
        add(fiveLines);
    }
}

class LinesModel implements Serializable {

    public static final String LINES_PROPERTY = "linesProperty";
    private int lines;

    private PropertyChangeSupport propertySupport;

    public LinesModel() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int value) {
        int oldValue = lines;
        lines = value;
        propertySupport.firePropertyChange(LINES_PROPERTY, oldValue, lines);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }  
}