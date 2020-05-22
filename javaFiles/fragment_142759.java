import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AddMatrixRows
{
    public static void main(String[] args)
    {
        double vector[] = {
            1.0, 1.0, 1.0, 1.0, 1.0, 
            2.0, 2.0, 2.0, 2.0, 2.0, 
            2.0, 2.0, 2.0, 3.0, 3.0, 
            3.0, 3.0, 3.0, 3.0};
        double matrix[][] = new double[vector.length][];
        for (int r=0; r<vector.length; r++)
        {
            matrix[r] = new double[] { 12, 34, 56 };
        }

        double sums[][] = computeSums(vector, matrix);
        for (int r=0; r<sums.length; r++)
        {
            System.out.println(Arrays.toString(sums[r]));
        }
    }

    private static double[][] computeSums(double vector[], double matrix[][])
    {
        Map<Integer, double[]> sumsByIndex = new LinkedHashMap<Integer, double[]>();
        for (int r=0; r<vector.length; r++)
        {
            int index = (int)vector[r];
            double array[] = sumsByIndex.get(index);
            if (array == null)
            {
                int numColumns = matrix[index].length;
                array = new double[numColumns];
                sumsByIndex.put(index, array);
            }
            add(array, matrix[index]);
        }
        return toArray(sumsByIndex.values());
    }

    private static double[][] toArray(Collection<double[]> collection)
    {
        double result[][] = new double[collection.size()][];
        int i = 0;
        for (double sum[] : collection)
        {
            result[i] = sum;
            i++;
        }
        return result;
    }

    private static void add(double array[], double addend[])
    {
        for (int i=0; i<array.length; i++)
        {
            array[i] += addend[i];
        }
    }
}