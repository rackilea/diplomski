import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            ColorChooserBtn btn = new ColorChooserBtn();
            add(btn);
            btn.addPropertyChangeListener("selectedColor", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    System.out.println("Changed");
                    System.out.println(evt.getNewValue());
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class ColorChooserBtn extends JButton {

        private Color color;

        public ColorChooserBtn() {
            super();
            this.setBackground(Color.BLACK);
            this.setPreferredSize(new Dimension(16, 16));
            this.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Choose color");
                    Color c = JColorChooser.showDialog(null, "Choose a Color", color);
                    if (c != null) {
                        setSelectedColor(c);
                        setBackground(color);
                    }
                }
            });
        }

        public Color getSelectedColor() {
            return color;
        }

        public void setSelectedColor(Color newColor) {
            if (newColor != color) {
                Color oldColor = color;
                color = newColor;
                firePropertyChange("selectedColor", oldColor, newColor);
            }
        }

    }
}