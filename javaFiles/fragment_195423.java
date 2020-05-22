import java.util.*;

public class Main {

    public static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    public static void floodFill(Position position, int oldColor, int newColor, int[][] image) {

        Queue<Position> queue = new LinkedList<Position>();
        queue.add(position);

        while (queue.size() > 0) {
            Position newPosition = queue.poll();

            if (newPosition.getY() >= 0 && newPosition.getY() < image.length // check bounds
                    && newPosition.getX() >= 0 && newPosition.getX() < image[0].length // check bounds
                    && image[newPosition.getY()][newPosition.getX()] == oldColor) {

                image[newPosition.getY()][newPosition.getX()] = newColor;

                queue.add(new Position(newPosition.getY(), newPosition.getX() - 1));
                queue.add(new Position(newPosition.getY(), newPosition.getX() + 1));
                queue.add(new Position(newPosition.getY() - 1, newPosition.getX()));
                queue.add(new Position(newPosition.getY() + 1, newPosition.getX()));
            }
        }
    }

    public static void main(String[] args) {

        int[][] array = new int[20][40]; // 20 rows, 40 columns

        for (int y = 0; y < array.length; y++) { // iterate through rows
            for (int x = 0; x < array[0].length; x++) // iterate through cols
                System.out.print(array[y][x]);
            System.out.println();
        }

        floodFill(new Position(5, 5), 0, 1, array);

        for (int y = 0; y < array.length; y++) { // iterate through rows
            for (int x = 0; x < array[0].length; x++) // iterate through cols
                System.out.print(array[y][x]);
            System.out.println();
        }
    }
}