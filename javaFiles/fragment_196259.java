import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DiceRoller {

    public static void main(String[] args) {
        new DiceRoller();
    }

    public DiceRoller() {
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
                frame.add(new DiePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DiePane extends JPanel {

        public DiePane() {
            setLayout(new BorderLayout());

            Die die = new Die();
            DieFaceComponent component = new DieFaceComponent(die);
            JButton roll = new JButton("Roll");
            roll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    die.roll();
                }
            });
            add(component);
            add(roll, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }

    public class Die {

        private PropertyChangeSupport propertyChangeSupport;
        private int faceValue;

        public Die() {
            propertyChangeSupport = new PropertyChangeSupport(this);
            System.out.println("Creating new Dice Object");
            //setValue(roll());
            roll(); // Roll sets the value any way :P
        }

        public int roll() {
            int val = (int) (6 * Math.random() + 1);
            setValue(val);
            return val;
        }

        public int getValue() {
            return faceValue;
        }

        public void setValue(int spots) {
            int old = faceValue;
            faceValue = spots;
            propertyChangeSupport.firePropertyChange("value", old, faceValue);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            propertyChangeSupport.addPropertyChangeListener(listener);
        }
    }

    public class DieFace {

        private int spotDiam, wOffset, hOffset, w, h;
        private Die die;

        public DieFace(Die die) {
            this.die = die
        }

        public void draw(Graphics g, int paneWidth, int paneHeight) {
            //draw information
        }
    }

    public class DieFaceComponent extends JComponent {

        private static final long serialVersionUID = 1L;

        private DieFace face;

        public DieFaceComponent(Die die) {
            face = new DieFace(die);
            die.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //revalidate();
            face.draw(g, super.getWidth(), super.getHeight());

        }
    }

}