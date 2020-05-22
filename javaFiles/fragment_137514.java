import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

        private PopUp popUp;

        public TestPane() {
            popUp = new PopUp(10, 10, 180, 180, 10, Color.yellow);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    popUp.animate(TestPane.this);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            popUp.draw(g);
            g2d.dispose();
        }

    }

    public class PopUp {

        /**
         * Expanded x coordinate
         */
        private double x;
        /**
         * Expanded y coordinate
         */
        private double y;
        /**
         * Expanded width value
         */
        private double width;
        /**
         * Expanded height value
         */
        private double height;

        /**
         * Number of steps until fully expanded
         */
        private int steps;
        /**
         * This divided by steps is the percentage the pop-up is expanded
         */
        private int expansionStage = 0;

        /**
         * Whether or not the pop-up is expanding
         */
        private boolean isExpanding = false;
        /**
         * Whether or not the pop-up is visible
         */
//      private boolean visible;

        /**
         * Color of the pop-up
         */
        private Color color;

        /**
         * The rectangle that represents the bounds of the pop-up
         */
        private Rectangle2D popUp;

        /**
         * The currently used transform for the pop-up
         */
        private AffineTransform trans;

        private Timer timer;
        private Component parent;

        /**
         * Initializes a newly created {@code PopUp} with a uniform color
         *
         * @param x The x coordinate of the expanded pop-up
         * @param y The y coordinate of the expanded pop-up
         * @param w The width of the expanded pop-up
         * @param h The height of the expanded pop-up
         * @param expansionSteps The number of steps until fully expanded
         * @param popUpColor The color of the pop-up
         */
        public PopUp(double x, double y, double w, double h, int expansionSteps, Color popUpColor) {
            this.x = x;
            this.y = y;
            width = w;
            height = h;
            color = popUpColor;
            steps = expansionSteps;
//          this.borderWidth = 0;
//          this.borderColor = null;
            popUp = new Rectangle2D.Double(0, 0, width, height);
//          setBounds((int) Math.round(x), (int) Math.round(y), (int) Math.round(w), (int) Math.round(h));
            trans = new AffineTransform();
            //Centers the rectangle pop-up at the center of the given rectangle made by the given x, y, width, and height
            trans.translate(x + width / 2 * (1 - (double) expansionStage / steps), y + height / 2 * (1 - (double) expansionStage / steps));
            //Scales the rectangle based on the percentage it is expanded
            trans.scale((double) expansionStage / steps, (double) expansionStage / steps);

            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    update();
                    parent.repaint();
                }
            });
        }

        public void animate(Component parent) {
            this.parent = parent;
            setExpanding(isCollapsed());
            timer.start();
        }

        public void update() {
            //Expands pop-up one step
            if (isExpanding) {
                if (!isExpanded()) {
                    expansionStage = Math.min(expansionStage + 1, steps);
                } else {
                    timer.stop();
                }
            } //Contracts pop-up one step
            else {
                if (!isCollapsed()) {
                    expansionStage = Math.max(expansionStage - 1, 0);
                } else {
                    timer.stop();
                }
            }
        }

        public boolean isCollapsed() {
            return (((double) expansionStage / (double) steps) == 0);
        }

        public boolean isExpanded() {
            return (((double) expansionStage / (double) steps) == 1);
        }

        /**
         * Draws the pop-up
         *
         * @param g Graphics object from paintComponent
         */
        public final void draw(Graphics g) {
//          if (visible) {
            //Sets the visibility of the JPanel to true if the pop-up is fully expanded (false otherwise)

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform trans = new AffineTransform();
            //Centers the rectangle pop-up at the center of the given rectangle made by the given x, y, width, and height

            trans.translate(x + width / 2 * (1 - (double) expansionStage / steps), y + height / 2 * (1 - (double) expansionStage / steps));
            //Scales the rectangle based on the percentage it is expanded
            trans.scale((double) expansionStage / steps, (double) expansionStage / steps);
            this.trans = trans;
            g2d.setColor(color);
            Shape transformed = trans.createTransformedShape(popUp);
            g2d.fill(transformed);
//          } else {
////                setVisible(false);
//          }
        }

        /**
         * Sets whether the pop-up is expanding or not
         *
         * @param expanding Whether or not the pop-up should expand
         */
        public final void setExpanding(boolean expanding) {
            isExpanding = expanding;
//          setVisible(expanding);
        }

        /**
         * Returns whether or not the pop-up is expanding
         *
         * @return Whether or not the pop-up is expanding
         */
        public final boolean getExpanding() {
            return isExpanding;
        }

        /**
         * Returns the percentage that the pop-up has expanded
         *
         * @return The percentage that the pop-up has expanded
         */
        public final double percentageExpanded() {
            return (double) expansionStage / steps;
        }

//      /**
//       * Different than JPanel.setVisible(boolean visible) in that it only draws
//       * the PopUp if this is true, and the JPanel is visible only when this is
//       * true and the popUp is expanded
//       *
//       * @param visible Whether or not the pop-up should be visible
//       */
//      public void setVisible(boolean visible) {
//          this.visible = visible;
//      }
//
//      /**
//       * Different than JPanel.isVisible() in that it only draws the PopUp if this
//       * is true, and the JPanel is visible only when this is true and the popUp
//       * is expanded
//       *
//       * @return Whether or not the pop-up should be visible
//       */
//      public boolean isVisible() {
//          return visible;
//      }
    }

}