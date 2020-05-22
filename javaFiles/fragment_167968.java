import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Test {

    public static class Coord {
        public int row;
        public int col;
    }

    public int[][] create2DArray() {
        Random r = new Random();
        int[][] array = new int[10][10];
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                array[row][col] = r.nextInt(100);
            }
        }
        return array;
    }

    public void print2DArray(int[][] array) {
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                System.out.print(array[row][col] + "\t");
            }
            System.out.println("");
        }
    }

    public List<Coord> getResult(int[][] array) {
        List<Coord> result = new ArrayList<>();

        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                if (array[row][col] % 3 == 0) {
                    Coord coord = new Coord();
                    coord.row = row;
                    coord.col = col;
                    result.add(coord);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int ar[][];        
        Test c = new Test();
        ar = c.create2DArray();
        c.print2DArray(ar);

        List<Coord> coords = c.getResult(ar);
        for (Coord coord: coords) {
            System.out.println(String.format("%d, %d", coord.row, coord.col));
        }
    }
}