import java.util.Arrays;

public class JavaApplication39 {

    public static void main(String[] args) {
        double[] dataEntries = {2.0, 2.2, 2.1, 1.0, 1.2, 1.1, 7.0,7.1,7.5};
        double[] dataGrouped = new double[dataEntries.length/3];
        int[] positions = new int[dataGrouped.length];

        int j=0;
        for (int i = 0; i < dataEntries.length; i+=3) {
            dataGrouped[j] = dataEntries[i];
            positions[j] = j;
            j++;                    
        }
        quickSort(dataGrouped,positions,0,dataGrouped.length-1);
        double[] merged = merge(dataEntries,positions);
        System.out.println(Arrays.toString(merged));
    }

    private static double[] merge(double[] dataEntries,int[] positions){
        double[] toReturn = new double[dataEntries.length];
        for (int i = 0; i < positions.length; i++) {
            toReturn[i*3] = dataEntries[positions[i]*3];
            toReturn[i*3+1] = dataEntries[positions[i]*3+1];
            toReturn[i*3+2] = dataEntries[positions[i]*3+2];
        }
        return toReturn;
    }

    private static void quickSort(double[] array, int[] positions, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array,positions, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,positions, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,positions, i, higherIndex);
    }

    private static void exchangeNumbers(double[] array, int[] positions, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        int postemp = positions[i];
        positions[i] = positions[j];
        positions[j] = postemp;
    }
}