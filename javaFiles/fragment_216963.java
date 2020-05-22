public class Test {

        public static void main(String... args) {

            Position[] positions = new Position[10];

            positions[0] = new Position(5, 10);
            positions[1] = new Position(11, 18);
            positions[2] = new Position(20, 7);

            PositionArray pa = new PositionArray(positions);

            System.out.println(pa.getPosAt(5, 10)); // Position{x=5, y=10}

        }
    }

    class PositionArray {

        private Position[] positions;

        public PositionArray(Position[] positions) {
            this.positions = positions;
        }

        public Position getPosAt(int x, int y) {

            for (Position p : positions) {
                if (!Objects.isNull(p)) {
                    System.out.println(p.getX() + " " + p.getY());
                    if (p.getX() == x && p.getY() == y) {
                        return p;
                    }
                }
            }
            return null;
        }
    }

    class Position {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Position{" + "x=" + x + ", y=" + y + '}';
        }

    }