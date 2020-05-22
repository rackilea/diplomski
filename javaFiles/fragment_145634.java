import java.awt.BasicStroke;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.Point;
    import java.awt.RenderingHints;
    import java.util.List;
    import java.util.Random;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    public class ExampleDrawDemo extends JPanel {

       int        WIDTH  = 600;
       int        HEIGHT = 500;
       JFrame     frame  = new JFrame();
       List<Line> lines;

       public static void main(String[] args) {
          SwingUtilities.invokeLater(() -> new ExampleDrawDemo().start());
       }
       public void start() {
          Random r = new Random();
          Color[] color = {
                Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE,
                Color.CYAN
          };

          // generate some lines.
          lines = IntStream.range(0, 100).mapToObj(
                i -> new Line(r, color[r.nextInt(color.length)])).collect(
                      Collectors.toList());

          setPreferredSize(new Dimension(600, 500));
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.add(this);
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
       }

       public void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g.create();
          // smooth lines
          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                   RenderingHints.VALUE_ANTIALIAS_ON);
          // line thickness
          g2d.setStroke(new BasicStroke(2));

          for (Line line : lines) {
             g2d.setColor(line.color);
             g2d.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
          }
          g2d.dispose();
       }

       class Line {
          Point start;
          Point end;
          Color color;

          public Line(Random r, Color color) {
             this.color = color;
             start = new Point(r.nextInt(WIDTH), r.nextInt(HEIGHT));
             end = new Point(r.nextInt(WIDTH), r.nextInt(HEIGHT));
          }
       }
    }