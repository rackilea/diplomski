import java.util.*;

class TestClass {


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Map<Point, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new TestClass().new Point(x, y);
            Integer value = map.get(point);
            if (value == null) {
                map.put(point, 1);
            } else map.put(point, value + 1);
        }
        StringBuilder sb = new StringBuilder();

        Comparator<Map.Entry<Point, Integer>> lexicoComparator = (e1, e2) -> {
            Point p1 = e1.getKey();
            Point p2 = e2.getKey();
            if (p1.x == p2.x){
                if (p1.y > p2.y)
                    return 1;
                if (p1.y == p2.y)
                    return 0;
                return -1;
            }
            if (p1.x > p2.x)
                return 1;
            return -1;
        };

        map.entrySet().
                stream().
                sorted(lexicoComparator).
                forEach(entry -> sb.append(entry.getKey().x + " " + entry.getKey().y + " " + entry.getValue() + "\n"));
        sb.delete(sb.length() - 1, sb.length());
        System.out.print(sb);
    }

}