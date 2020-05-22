import java.util.*;
import java.util.stream.Collectors;

public class Snippet {

    // make a class to be more flexible
    class Coordinate {

        // final fields are making this an "imutable"
        final int x;
        final int y;

        /** constructor to take coordinate values */
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /** moves this coordinate by another coordinate */
        Coordinate move(Coordinate vector) {
            return new Coordinate(x + vector.x, y + vector.y);
        }
    }

    /** using Collection instead of Array makes your live easier. Consider renaming this to "directions". */
    Collection<Coordinate> coordinates = Arrays.asList(
            new Coordinate( -1, -1 ), // left top
            new Coordinate( -1,  0 ), // left middle
            new Coordinate( -1, +1 ), // left bottom
            new Coordinate(  0, -1 ), // top
            new Coordinate(  0, +1 ), // bottom
            new Coordinate( +1, -1 ), // right top
            new Coordinate( +1,  0 ), // right middle
            new Coordinate( +1, +1 )  // right bottom
            );

    /** @return a collection of eight nearest coordinates near origin */
    Collection<Coordinate> getNearCoordinates(Coordinate origin) {
        return
                // turn collection into stream
                coordinates.stream()

                // move the origin into every direction
                .map(origin::move)

                // turn stream to collection
                .collect(Collectors.toList());
    }

}