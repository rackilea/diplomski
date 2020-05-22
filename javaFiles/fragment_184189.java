import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.SetUtils;

public class IntersectionSetCalculation {

    private static class ManhattanDistanceArea {

        private String id;
        private Vector3D center;
        private double distance;

        public ManhattanDistanceArea(Vector3D center, double distance, String id) {
            this.center = center;
            this.distance = distance;
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((center == null) ? 0 : center.hashCode());
            long temp;
            temp = Double.doubleToLongBits(distance);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ManhattanDistanceArea other = (ManhattanDistanceArea) obj;
            if (center == null) {
                if (other.center != null)
                    return false;
            }
            else if (!center.equals(other.center))
                return false;
            if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            }
            else if (!id.equals(other.id))
                return false;
            return true;
        }

        public boolean intersects(ManhattanDistanceArea other) {
            double maxDist = distance + other.distance;
            return center.distance(other.center, 1) < maxDist;
        }
    }

    /**
     * Calculate the intersection of all areas (maximum of 2 areas in an intersection)
     */
    public static Set<Set<ManhattanDistanceArea>> getIntersectingAreas(Set<ManhattanDistanceArea> areas) {
        Set<Set<ManhattanDistanceArea>> intersections = new HashSet<Set<ManhattanDistanceArea>>();

        for (ManhattanDistanceArea area : areas) {
            for (ManhattanDistanceArea area2 : areas) {
                if (!area.equals(area2) && area.intersects(area2)) {
                    HashSet<ManhattanDistanceArea> intersection = new HashSet<ManhattanDistanceArea>();
                    intersection.add(area);
                    intersection.add(area2);
                    intersections.add(intersection);
                }
            }
        }

        Set<Set<ManhattanDistanceArea>> combined = combineIntersections(intersections);
        Set<Set<ManhattanDistanceArea>> reduced = reduceIntersections(combined);

        return reduced;
    }

    /**
     * Combine the small intersections (with a maximum of 2 areas in an intersection) to bigger intersections
     */
    public static Set<Set<ManhattanDistanceArea>> combineIntersections(Set<Set<ManhattanDistanceArea>> inters) {
        Set<Set<ManhattanDistanceArea>> intersections = new HashSet<Set<ManhattanDistanceArea>>(inters);
        Set<Set<ManhattanDistanceArea>> combinations;

        do {
            combinations = new HashSet<Set<ManhattanDistanceArea>>();

            for (Set<ManhattanDistanceArea> intersecting1 : intersections) {
                for (Set<ManhattanDistanceArea> intersecting2 : intersections) {
                    Set<ManhattanDistanceArea> diff_1_2 = SetUtils.difference(intersecting1, intersecting2);
                    Set<ManhattanDistanceArea> diff_2_1 = SetUtils.difference(intersecting2, intersecting1);

                    if (diff_1_2.size() == 1 && diff_2_1.size() == 1) {
                        Set<ManhattanDistanceArea> union_1_2 = SetUtils.union(diff_1_2, diff_2_1);

                        if (intersections.contains(union_1_2)) {
                            Set<ManhattanDistanceArea> union = SetUtils.union(intersecting1, intersecting2);
                            if (!intersections.contains(union)) {
                                combinations.add(union);
                            }
                        }
                    }
                }
            }

            intersections.addAll(combinations);

        } while (!combinations.isEmpty());

        return intersections;
    }

    /**
     * Remove the small intersections that are completely covered by bigger intersections
     */
    public static Set<Set<ManhattanDistanceArea>> reduceIntersections(Set<Set<ManhattanDistanceArea>> inters) {
        Set<Set<ManhattanDistanceArea>> intersections = new HashSet<Set<ManhattanDistanceArea>>(inters);
        Iterator<Set<ManhattanDistanceArea>> iter = intersections.iterator();

        while (iter.hasNext()) {
            Set<ManhattanDistanceArea> intersection = iter.next();
            for (Set<ManhattanDistanceArea> intersection2 : inters) {
                if (intersection2.size() > intersection.size() && intersection2.containsAll(intersection)) {
                    iter.remove();
                    break;
                }
            }
        }

        return intersections;
    }

    public static void main(String[] args) {
        final double dist = 2d;//the manhattan distance d

        ManhattanDistanceArea A = new ManhattanDistanceArea(new Vector3D(0, -3, 0), dist, "A");
        ManhattanDistanceArea B = new ManhattanDistanceArea(new Vector3D(0, 0, 0), dist, "B");
        ManhattanDistanceArea C = new ManhattanDistanceArea(new Vector3D(3.5, 0, 0), dist, "C");
        ManhattanDistanceArea D = new ManhattanDistanceArea(new Vector3D(0, 3.5, 0), dist, "D");
        ManhattanDistanceArea E = new ManhattanDistanceArea(new Vector3D(1, 1, 0), dist, "E");

        ManhattanDistanceArea F = new ManhattanDistanceArea(new Vector3D(-1, 1, 0), dist, "F");

        //test the example you provided
        Set<ManhattanDistanceArea> abcde = new HashSet<ManhattanDistanceArea>();
        abcde.addAll(Arrays.asList(new ManhattanDistanceArea[] {A, B, C, D, E}));

        //test another example
        Set<ManhattanDistanceArea> abcdef = new HashSet<ManhattanDistanceArea>();
        abcdef.addAll(abcde);
        abcdef.add(F);

        Set<Set<ManhattanDistanceArea>> intersectionsABCDE = getIntersectingAreas(abcde);
        Set<Set<ManhattanDistanceArea>> intersectionsABCDEF = getIntersectingAreas(abcdef);

        System.out.println(intersectionsABCDE);
        System.out.println(intersectionsABCDEF);

        //test the runntime for 1000 calculation
        double startTime = System.currentTimeMillis();
        final int calculations = 1000;
        for (int i = 0; i < calculations; i++) {
            Set<ManhattanDistanceArea> areas = new HashSet<ManhattanDistanceArea>();
            for (int j = 0; j < 20; j++) {
                areas.add(new ManhattanDistanceArea(new Vector3D(Math.random() * 10 - 5, Math.random() * 10 - 5, Math.random() * 10 - 5), dist,
                        "A" + j));
            }

            getIntersectingAreas(areas);
        }
        System.out.println("\nTime used for " + calculations + " intersection calculations (with sets of size 20): "
                + (System.currentTimeMillis() - startTime) + "ms");
    }
}