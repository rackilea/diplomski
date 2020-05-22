import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SortXYZ {

    private final double x;
    private final String y;
    private final double z;

    public SortXYZ(double x, String y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "SortXYZ{x=" + x + ", y=" + y + ", z=" + z + "}";
    }

    private static Comparator<SortXYZ> comparator;

    public static void main(String[] arg) {
        List<SortXYZ> list = asList(new SortXYZ(1, "A", 2), new SortXYZ(1, "A", 0), new SortXYZ(2, "B", 1));

        String sortSeq = "YXZ";

        comparator = comparing(function(sortSeq.charAt(0)));
        sortSeq.chars().skip(1).forEach(c -> comparator = comparator.thenComparing(function((char) c)));

        List<SortXYZ> sortedList = list.stream().sorted(comparator).collect(toList());

        System.out.println(sortedList);
    }

    public static Function<SortXYZ, ? extends Comparable> function(char c) {
        switch (c) {
            case 'X': return SortXYZ::getX;
            case 'Y': return SortXYZ::getY;
            case 'Z': return SortXYZ::getZ;
            default:  throw new IllegalArgumentException("" + c);
        }
    }

}