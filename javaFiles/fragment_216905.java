import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        int[][] array = { {1,0,1}, {1,0,1}, {1,1,1} };
        int[][] newArray = replicate(array);

        int i = 1;

        System.out.print("[ ");
        for(int[] a : newArray)
        {
            System.out.print(Arrays.toString(a) + (i++ != newArray.length? ", " : "") );
        }
        System.out.println(" ]");
    }

    public static int[][] replicate(int[][] array)
    {
        int x = array.length;
        int y = array[0].length;

        int counterX = 0;
        int counterY = 0;

        int[][] newArray = new int[2 * x][2 * y];
        for(int[] a : array)
        {
            for(int b : a)
            {
                newArray[counterX++][counterY] = b;
                newArray[counterX--][counterY++] = b;

                newArray[counterX++][counterY] = b;
                newArray[counterX--][counterY++] = b;
            }
            counterY = 0;
            counterX++;
            counterX++;
        }

        return newArray;
    }
}