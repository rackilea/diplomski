public class ArrayTest {
    public static enum Direction {
       LEFT, RIGHT, UP, DOWN, SELF;

       public int getValue(int[][] array, int yIndex, int xIndex) {
           switch(this) {
               case LEFT:
                   if (xIndex == 0) return array[yIndex][xIndex];
                   return array[yIndex][xIndex - 1];
               case RIGHT:
                   if (xIndex == array[yIndex].length - 1) return array[yIndex][xIndex];
                   return array[yIndex][xIndex + 1];
               case UP:
                   if (yIndex == 0) return array[yIndex][xIndex];
                   return array[yIndex - 1][xIndex];
               case DOWN:
                   if (yIndex == array.length - 1) return array[yIndex][xIndex];
                   return array[yIndex + 1][xIndex];
               default:
                   return array[yIndex][xIndex];
           }
       }
   }

    public static int[][] buildE(int[][] array) {
        int [][] arrayE = new int[array.length][array[0].length];

        for (int y = 0; y < array.length; y++) {
            System.out.println("y = " + y);
            for (int x = 0; x < array[y].length; x++) {
                arrayE[y][x] = 0;
                for (Direction d : Direction.values()) {
                    arrayE[y][x] += d.getValue(array, y, x);
                }
            }
        }

        return arrayE;
    }

    public static void outputArray(int[][] array) {
        for(int row = 0; row < array.length; row ++) {
            for (int column = 0; column < array[row].length; column++)
                System.out.printf("%d ", array[row][column]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] myArray = {{1, 12, 13, 14, 15}, {2, 22, 23, 24, 25}, {3, 32, 33, 34, 35}, {4, 42, 43, 44, 45}, {5, 52, 53, 54, 55}, {6, 62, 63, 64, 65}};

        outputArray(myArray);
        outputArray(buildE(myArray));
    }
}