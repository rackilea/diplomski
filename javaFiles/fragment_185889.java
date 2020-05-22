import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGraph {

    public static void main(String[] args) {
        new TestGraph();
    }

    public TestGraph() {
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
                frame.add(new GraphPane(0, 100, new int[100]));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class GraphPane extends JPanel {

        protected static final int COLUMN_WIDTH = 10;
        protected static final int VERTICAL_INSETS = 10;

        private int[] data;
        private int minValue, maxValue;
        private Path2D.Double graph;
        private List<Shape> buttons;

        private Point mousePoint;

        public GraphPane(int minValue, int maxValue, int[] data) {
            this.data = data;
            this.minValue = minValue;
            this.maxValue = maxValue;

            buttons = new ArrayList<>(data == null ? 25 : data.length);

            updateView();

            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    updateData(e);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    updateData(e);
                }
            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        protected void updateData(MouseEvent e) {

            // Which "column" was clicked on
            int column = (int) Math.round(((double) e.getX() / (double) COLUMN_WIDTH)) - 1;
            // Get the "height" of the clickable area
            int clickRange = getHeight() - (VERTICAL_INSETS * 2);
            // Adjust the y click point for the margins...
            int yPos = e.getY() - VERTICAL_INSETS;

            // Calculate the vertical position that was clicked
            // this ensures that the range is between 0 and clickRange
            // You could choose to ignore values out side of this range
            int row = Math.min(Math.max(clickRange - yPos, 0), clickRange);

            // Normalise the value between 0-1
            double clickNormalised = row / (double) clickRange;

            // Calculate the actual row value...
            row = minValue + (int) (Math.round(clickNormalised * maxValue));

            // Update the data
            data[column] = row;

            mousePoint = new Point(
                            COLUMN_WIDTH + (column * COLUMN_WIDTH), 
                            getHeight() - (VERTICAL_INSETS + (int) Math.round((data[column] / 100d) * clickRange)));

            updateView();

            repaint();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            updateView();
        }

        protected Shape createButton(int xPos, int yPos) {

            return new Ellipse2D.Double(xPos - COLUMN_WIDTH / 2, yPos - COLUMN_WIDTH / 2, COLUMN_WIDTH, COLUMN_WIDTH);

        }

        protected void updateView() {

            graph = new Path2D.Double();
            buttons.clear();
            if (data != null && data.length > 0) {

                int verticalRange = getHeight() - (VERTICAL_INSETS * 2);

                int xPos = COLUMN_WIDTH;
                int yPos = getHeight() - (VERTICAL_INSETS + (int) Math.round((data[0] / 100d) * verticalRange));
                graph.moveTo(xPos, yPos);

                if (data[0] > 0) {
                    buttons.add(createButton(xPos, yPos));
                }

                for (int index = 1; index < data.length; index++) {

                    xPos = (index * COLUMN_WIDTH) + COLUMN_WIDTH;
                    yPos = getHeight() - (VERTICAL_INSETS + (int) Math.round((data[index] / 100d) * verticalRange));

                    graph.lineTo(xPos, yPos);

                    if (data[index] > 0) {
                        buttons.add(createButton(xPos, yPos));
                    }

                }

            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(data == null ? 0 : (data.length + 1) * COLUMN_WIDTH, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (data != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(64, 64, 64, 32));
                for (int index = 0; index < data.length; index++) {
                    int xPos = (index * COLUMN_WIDTH) + COLUMN_WIDTH;
                    g2d.drawLine(xPos, VERTICAL_INSETS, xPos, getHeight() - VERTICAL_INSETS);
                }

                g2d.setColor(Color.BLACK);
                g2d.draw(graph);

                for (Shape button : buttons) {
                    g2d.fill(button);
                }

                if (mousePoint != null) {
                    g2d.setColor(new Color(255, 192, 203));
                    Ellipse2D dot = new Ellipse2D.Double((mousePoint.x - COLUMN_WIDTH / 2) - 2, (mousePoint.y - COLUMN_WIDTH / 2) - 2, COLUMN_WIDTH + 4, COLUMN_WIDTH + 4);
                    g2d.draw(dot);
                    g2d.setColor(new Color(255, 192, 203, 128));
                    g2d.fill(dot);
                }

                g2d.dispose();
            }
        }

    }

}