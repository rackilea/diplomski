import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Altimiter {

    public static void main(String[] args) {
        new Altimiter();
    }

    public Altimiter() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private AltPane altPane;

        public TestPane() {

            JButton up = new JButton("+");
            JButton down = new JButton("-");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(up, gbc);
            gbc.gridy++;
            add(down, gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.gridheight = GridBagConstraints.REMAINDER;

            altPane = new AltPane();
            add(altPane, gbc);

            up.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    altPane.setSpeed(25);
                }
            });
            down.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    altPane.setSpeed(-25);
                }
            });

            altPane.setValue(0);

        }
    }

    public class AltPane extends JPanel {

        private LinearScrollerPane major;
        private CircularScrollerPane minor;
        private int altitude = 0;
        private int direction = 0;
        private Timer timer;

        public AltPane() {
            major = new LinearScrollerPane();
            minor = new CircularScrollerPane();
            major.setOpaque(false);
            minor.setOpaque(false);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.weighty = 1; 

            add(major, gbc);
            gbc.gridx++;
            add(minor, gbc);
            setBorder(new LineBorder(Color.BLUE));

            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    altitude += direction;
                    if (altitude < 0) {
                        ((Timer) e.getSource()).stop();
                        altitude = 0;
                    } else if (altitude > 20000) {
                        ((Timer) e.getSource()).stop();
                        altitude = 20000;
                    }
                    System.out.println("value = " + altitude);
                    setValue(altitude);
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.setInitialDelay(0);
        }

        public void setSpeed(int speed) {
            this.direction = speed;
            timer.start();
        }

        public void setValue(int value) {
            int hnds = value / 100;
            int units = value - (hnds * 100);

            if (units == 0) {
                if (hnds > 0 && direction > 0) {
                    units = 100;
                } else if (hnds > 0 && direction < 0) {
                    units = -1;
                } else {
                    units = 0;
                }
            }

            major.setValue(hnds);
            minor.setValue(units);

            invalidate();
            repaint();
        }

        public int getValue() {
            int ths = major.getValue();
            int hnds = minor.getValue();
            return (ths * 100) + hnds;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Insets insets = getInsets();
            int width = getWidth() - (insets.left + insets.top);
            int height = getHeight() - (insets.top + insets.bottom);
            g.setColor(new Color(255, 0, 0, 128));
            int centerY = insets.top + (height / 2);
            g.drawLine(insets.left, centerY, insets.left + width, centerY);
        }
    }

    public class CircularScrollerPane extends JPanel {

        private BufferedImage baseView;
        private BoundedRangeModel model;
        private float startValue = 0;
        private float currentValue = 0;
        private float targetValue = 0;
        private int rowCount = 3;
        private Timer timer;
        private long startTime;
        private int runTime = 1000;

        public CircularScrollerPane() {
            setModel(new DefaultBoundedRangeModel(0, 20, 0, 100));

            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long now = System.currentTimeMillis();
                    long diff = now - startTime;
                    if (diff >= runTime) {
                        ((Timer) (e.getSource())).stop();
                        diff = runTime;
                    }
                    float progress = (float) diff / (float) runTime;

                    currentValue = calculateProgress(startValue, targetValue, progress);
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(false);
        }

        public int getValue() {
            return getModel().getValue();
        }

        public void setValue(int value) {
            timer.stop();

            BoundedRangeModel model = getModel();
            if (value < model.getMinimum()) {
                value = model.getMaximum() + (value + 1);
                currentValue += model.getMaximum(); // overflow
            } else if (value > model.getMaximum() - model.getExtent()) {
                value = model.getMinimum() + (value - model.getMaximum());
                currentValue -= model.getMaximum(); // underflow
            }
            startValue = currentValue;
            targetValue = value;

            model.setValue(value);

            startTime = System.currentTimeMillis();
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            return fm == null ? super.getPreferredSize() : new Dimension(fm.stringWidth("MMM"), fm.getHeight() * getRowCount());
        }

        public void setRowCount(int value) {
            if (value != rowCount) {
                int old = rowCount;
                rowCount = value;
                invalidate();
                repaint();
                firePropertyChange("rowCount", old, rowCount);
            }
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setModel(BoundedRangeModel value) {
            if (value != null) {
                BoundedRangeModel old = model;
                model = value;
                if (model != null) {
                    currentValue = model.getValue();
                    targetValue = model.getValue();
                } else {
                    currentValue = 0;
                    targetValue = 0;
                }
                baseView = null;
                firePropertyChange("model", old, model);
            }
        }

        public BoundedRangeModel getModel() {
            return model;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            baseView = null;
        }

        public float getViewOffSet(float value) {
            Font font = getFont();
            FontMetrics fm = getFontMetrics(font);
            int rowHeight = fm.getHeight();
            int extent = model.getExtent();
            int min = model.getMinimum();
            int max = model.getMaximum();

            int viewRange = max - min;
            int ticks = viewRange / extent;

            float p = value / (float) viewRange;

            return ((rowHeight * ticks) * p) + ((fm.getAscent() + fm.getDescent()) / 2);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            BufferedImage masterView = getMasterView();
            if (masterView != null) {

                Insets insets = getInsets();
                int width = getWidth() - (insets.left + insets.right);
                int height = getHeight() - (insets.top + insets.bottom);
                int centerY = height / 2;
                FontMetrics fm = g.getFontMetrics();

                int yOffset = centerY - (int) getViewOffSet(currentValue);

                g.drawImage(masterView, insets.left, insets.top + yOffset, this);

                // Heading image...
                if (yOffset > 0) {
                    g.drawImage(masterView, insets.left, insets.top + yOffset - masterView.getHeight(), this);
                }
                // Tailing image...
                if (yOffset + masterView.getHeight() < height) {
                    g.drawImage(masterView, insets.left, insets.top + yOffset + masterView.getHeight(), this);
                }
            }
        }

        protected String pad(int value) {
            StringBuilder sb = new StringBuilder(value);
            sb.ensureCapacity(3);
            sb.append(value);
            while (sb.length() < 3) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }

        protected BufferedImage getMasterView() {
            if (baseView == null) {
                Insets insets = getInsets();
                int width = getWidth() - (insets.left + insets.right);
                int height = getHeight() - (insets.top + insets.bottom);

                BoundedRangeModel model = getModel();

                int extent = model.getExtent();
                int min = model.getMinimum();
                int max = model.getMaximum();

                int viewRange = max - min;
                int ticks = viewRange / extent;

                Font font = getFont();
                FontMetrics fm = getFontMetrics(font);
                baseView = new BufferedImage(width, fm.getHeight() * ticks, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = baseView.createGraphics();
                g2d.setFont(font);
                g2d.setColor(Color.BLACK);
                int yPos = 0;
                for (int index = min; index < max; index += extent) {
                    String value = pad(index);
                    g2d.drawString(value, width - fm.stringWidth(value), yPos + fm.getAscent());
                    yPos += fm.getHeight();
                }
            }
            return baseView;
        }
    }

    public class LinearScrollerPane extends JPanel {

        private BufferedImage baseView;
        private BoundedRangeModel model;
        private float startValue = 0;
        private float currentValue = 0;
        private float targetValue = 0;
        private int rowCount = 3;
        private Timer timer;
        private long startTime;
        private int runTime = 1000;

        public LinearScrollerPane() {

            Font font = UIManager.getFont("Label.font");
            setFont(font.deriveFont(Font.BOLD, font.getSize() + 4));
            setModel(new DefaultBoundedRangeModel(0, 0, 0, 20));

            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long now = System.currentTimeMillis();
                    long diff = now - startTime;
                    if (diff >= runTime) {
                        ((Timer) (e.getSource())).stop();
                        diff = runTime;
                    }
                    float progress = (float) diff / (float) runTime;

                    currentValue = calculateProgress(startValue, targetValue, progress);
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(false);
        }

        public int getValue() {
            return getModel().getValue();
        }

        public void setValue(int value) {
            timer.stop();

            BoundedRangeModel model = getModel();
            if (value < model.getMinimum()) {
                value = model.getMinimum();
            } else if (value > model.getMaximum() - model.getExtent()) {
                value = model.getMaximum() - model.getExtent();
            }
            startValue = currentValue;
            targetValue = value;

            model.setValue(value);

            startTime = System.currentTimeMillis();
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            return fm == null ? super.getPreferredSize() : new Dimension(fm.stringWidth("MM"), fm.getHeight() * getRowCount());
        }

        public void setRowCount(int value) {
            if (value != rowCount) {
                int old = rowCount;
                rowCount = value;
                invalidate();
                repaint();
                firePropertyChange("rowCount", old, rowCount);
            }
        }

        public int getRowCount() {
            return rowCount;
        }

        public void setModel(BoundedRangeModel value) {
            if (value != null) {
                BoundedRangeModel old = model;
                model = value;
                if (model != null) {
                    currentValue = model.getValue();
                    targetValue = model.getValue();
                } else {
                    currentValue = 0;
                    targetValue = 0;
                }
                baseView = null;
                firePropertyChange("model", old, model);
            }
        }

        public BoundedRangeModel getModel() {
            return model;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            baseView = null;
        }

        public float getViewOffSet(float value) {
            Font font = getFont();
            FontMetrics fm = getFontMetrics(font);
            int rowHeight = fm.getHeight();
            int min = model.getMinimum();
            int max = model.getMaximum();

            int viewRange = max - min;
            int ticks = getTicks();

            float p = value / (float) viewRange;

            return ((rowHeight * ticks) * p) + ((fm.getAscent() + fm.getDescent()) / 2);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            BufferedImage masterView = getMasterView();
            if (masterView != null) {

                Insets insets = getInsets();
                int width = getWidth() - (insets.left + insets.right);
                int height = getHeight() - (insets.top + insets.bottom);
                int centerY = height / 2;
                FontMetrics fm = g.getFontMetrics();

                int yOffset = centerY - (int) getViewOffSet(currentValue);

                g.drawImage(masterView, insets.left, insets.top + yOffset, this);
            }
        }

        protected String pad(int value) {
            StringBuilder sb = new StringBuilder(value);
            sb.ensureCapacity(3);
            sb.append(value);
            while (sb.length() < 3) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }

        protected int getTicks() {
            BoundedRangeModel model = getModel();

            int extent = model.getExtent();
            int min = model.getMinimum();
            int max = model.getMaximum();
            int viewRange = max - min;
            int ticks = viewRange;
            if (extent > 0) {
                ticks = viewRange / extent;
            }

            return ticks;
        }

        protected BufferedImage getMasterView() {
            if (baseView == null) {
                Insets insets = getInsets();
                int width = getWidth() - (insets.left + insets.right);
                int height = getHeight() - (insets.top + insets.bottom);

                BoundedRangeModel model = getModel();

                int extent = model.getExtent();
                int min = model.getMinimum();
                int max = model.getMaximum();

                int ticks = getTicks() + 1;

                Font font = getFont();
                FontMetrics fm = getFontMetrics(font);
                baseView = new BufferedImage(width, fm.getHeight() * ticks, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = baseView.createGraphics();
                g2d.setFont(font);
                g2d.setColor(Color.BLACK);
                int yPos = 0;
                for (int index = min; index < max + 1; index += Math.max(1, extent)) {
                    String value = String.valueOf(index);
                    g2d.drawString(value, width - fm.stringWidth(value), yPos + fm.getAscent());
                    yPos += fm.getHeight();
                }
                g2d.dispose();
            }
            return baseView;
        }
    }

    public static float calculateProgress(float startValue, float endValue, double fraction) {
        float value = 0;
        float distance = endValue - startValue;
        value = (float) (distance * fraction);
        value += startValue;
        return value;
    }
}