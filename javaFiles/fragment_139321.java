public class Line {

   private final Point start;
   private final Point end;

   public Line(final Point start, final Point end) {
       this.start = new Point(start);
       this.end = new Point(end);
   }

   public Point getStart() {
       return new Point(start);
   }

   public Point getEnd() {
       return new Point(end);
   }
}