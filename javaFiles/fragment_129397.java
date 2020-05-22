import java.awt.Graphics;
import java.util.LinkedList;

public class DrawLines{

    public DrawLines() {

    }

    private static class Line {
        final int x1;
        final int y1;
        final int x2;
        final int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

        }

    }

    private final LinkedList<Line> lines = new LinkedList<Line>();

    public void addLine(int x1, int x2, int x3, int x4) {
        lines.add(new Line(x1, x2, x3, x4));
    }

    public void clearLines() {
        lines.clear();
    }

    public void draw(Graphics g){
        for (Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }
}