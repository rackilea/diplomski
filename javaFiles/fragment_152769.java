public class Solver {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class State {

        static State best;
        State parent;
        List<State> children = new ArrayList<>();
        int length;
        Point p;

        public State(State parent, Point p) {
            this.parent = parent;
            this.p = p;
            this.length = parent.length + 1;
            this.parent.children.add(this);
            if (best.length < length) {
                best = this;
            }
        }

        public State(Point p) {
            this.parent = null;
            this.p = p;
            this.length = 1;
            if (best == null) {
                best = this;
            }
        }

        public void checkParent(State st) {
            if (st.length + 1 > length) {
                parent.children.remove(this);
                this.parent = st;
                updateLength();
            }
        }

        private void updateLength() {
            this.length = parent.length + 1;
            if (best.length < length) {
                best = this;
            }
            for (State state : children) {
                state.updateLength();
            }
        }
    }

    public static boolean checkRange(int min, int max, int x) {
        return min <= x && x < max;
    }

    public static boolean maxLocal(int x, int y, int[][] points) {
        int value = points[x][y];
        if (x > 0 && points[x - 1][y] > value) {
            return false;
        }
        if (y > 0 && points[x][y - 1] > value) {
            return false;
        }
        if (x < points.length - 1 && points[x + 1][y] > value) {
            return false;
        }
        return !(y < points[0].length - 1 && points[x][y + 1] > value);
    }

    private static List<Point> getNeigbours(int x, int y, int[][] points) {
        int value = points[x][y];
        List<Point> result = new ArrayList<>(4);
        if (x > 0 && points[x - 1][y] < value) {
            result.add(new Point(x - 1, y));
        }
        if (y > 0 && points[x][y - 1] < value) {
            result.add(new Point(x, y - 1));
        }
        if (x < points.length - 1 && points[x + 1][y] < value) {
            result.add(new Point(x + 1, y));
        }
        if (y < points[0].length - 1 && points[x][y + 1] < value) {
            result.add(new Point(x, y + 1));
        }
        return result;
    }

    private static int[][] generateRandomPoint(int width, int height, int max) {
        int[][] result = new int[width][height];
        Random rand = new Random(0L);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = rand.nextInt(max);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = generateRandomPoint(50, 50, 100);
        State[][] states = new State[points.length][points[0].length];
        List<State> candidates = new ArrayList<>(points.length*points[0].length);
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[0].length; y++) {
                if (maxLocal(x, y, points)) {
                    states[x][y] = new State(new Point(x, y));
                    candidates.add(states[x][y]);
                }
            }
        }
        while (!candidates.isEmpty()) {
            State candidate = candidates.remove(candidates.size() - 1);
            for (Point p : getNeigbours(candidate.p.x, candidate.p.y, points)) {
                if (states[p.x][p.y] == null) {
                    states[p.x][p.y] = new State(candidate, p);
                    candidates.add(states[p.x][p.y]);
                } else {
                    states[p.x][p.y].checkParent(candidate);
                }
            }
        }
        State temp = State.best;
        List<Point> pointList = new ArrayList<>(temp.length);
        while (temp != null) {
            pointList.add(temp.p);
            temp = temp.parent;
        }
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[0].length; y++) {
                if (points[x][y] < 10) {
                    System.out.print("  ");
                } else if (points[x][y] < 100) {
                    System.out.print(" ");
                }
                System.out.print(points[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
        for (Point point : pointList) {
            System.out.println(point.x + ", " + point.y + " -> " + points[point.x][point.y]);
        }

        System.out.println();
        System.out.println("lengths:");
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[0].length; y++) {
                if (states[x][y].length < 10) {
                    System.out.print(" ");
                }
                System.out.print(states[x][y].length + " ");
            }
            System.out.println();
        }
    }
}