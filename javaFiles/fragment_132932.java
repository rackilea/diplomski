import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TurningPoints
{
    public static void main(String[] args)
    {
        List<Point> points = new ArrayList<Point>();
        points.add(createPoint("A", 1, 0));
        points.add(createPoint("B", 1, 1));
        points.add(createPoint("C", 1, 2));
        points.add(createPoint("D", 2, 2));
        points.add(createPoint("E", 3, 1));
        points.add(createPoint("F", 4, 1));
        points.add(createPoint("G", 5, 1));
        points.add(createPoint("H", 5, 2));

        List<Integer> indices = computeTurningPointIndices(points);
        System.out.println("Turning points are at " + indices);

        List<Point> turningPoints = indices.stream().map(i -> points.get(i))
            .collect(Collectors.toList());
        System.out.println("They are " + turningPoints);

        System.out.println("Collinear:");
        indices.add(0, 0);
        indices.add(points.size() - 1);
        for (int i = 0; i < indices.size() - 1; i++)
        {
            int i0 = indices.get(i);
            int i1 = indices.get(i + 1);
            List<Point> collinear = points.subList(i0, i1 + 1);

            System.out.println("    " + collinear);
        }
    }

    private static List<Integer> computeTurningPointIndices(List<Point> points)
    {
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 1; i < points.size() - 1; i++)
        {
            Point prev = points.get(i - 1);
            Point curr = points.get(i);
            Point next = points.get(i + 1);
            int dxPrev = prev.x - curr.x;
            int dyPrev = prev.y - curr.y;
            int dxNext = next.x - curr.x;
            int dyNext = next.y - curr.y;
            if (dxPrev != dxNext && dyPrev != dyNext)
            {
                indices.add(i);
            }
        }
        return indices;
    }

    private static Point createPoint(String name, int x, int y)
    {
        // Only for this example. You should usually not do this!
        return new Point(x, y)
        {
            @Override
            public String toString()
            {
                return name + "(" + x + "," + y + ")";
            }
        };
    }

}