import java.util.ArrayList;
import java.util.Random;

public class JavaPerformanceTest {
    public static void main(String[] args) {
        int numColumns = 5;
        int numRows = 10000000;
        byte[][] data = new byte[numColumns][numRows];
        Random rand = new Random(1234);
        for (int j = 0; j < numColumns; j++) {
            for (int i = 0; i < numRows; i++) {
                data[j][i] = (byte) rand.nextInt(20);
            }
        }
        int warmUp = 10;
        ArrayList<Integer> sums = new ArrayList<Integer>();
        System.out.println("warm up " + warmUp + " times");
        long warmUpStart = System.nanoTime();
        for (int i = 0; i < warmUp; i++) {
            sums.add(sum(numRows, data));
        }
        long warmUpEnd = System.nanoTime();
        System.out.println("warm up complete " + (warmUpEnd - warmUpStart) / 1000000);
        for (int t = 0; t < 3; t++) {
            int numberOfRuns = 100;
            int finalSum = 0;
            long startTime = System.nanoTime();
            for (int i = 0; i < numberOfRuns; i++) {
                finalSum = sum(numRows, data);
            }
            long endTime = System.nanoTime();
            long diff = (endTime - startTime) / 1000000;
            System.out.println("Time taken: " + diff + "    Sum: " + finalSum);
        }
    }


    public static int sum(int numRows, byte[][] columnBased) {
        int sum = 0;
        byte[] col1 = columnBased[1];
        byte[] col2 = columnBased[2];
        for (int i = 0; i < numRows; i++)
            // use multiplication instead of "if" to avoid branch prediction failures
            sum += ((col1[i] + 1) & 1) * col2[i];
        return sum;
    }
}