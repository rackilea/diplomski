package test2.newpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/test.txt")); // replaced with my test file here
        String line;
        final int rows = 6; // row count never changes
        int[][] myArray = new int[rows][];
        int currentRow = 0;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            // System.out.println(line); // write file content to System.out just to be sure it's the right file
            String[] nums = line.trim().split(" "); // remove spaces at both ends of string before splitting
            int[] intLine = new int[nums.length];
            myArray[currentRow++] = intLine;
            for (int col = 0; col < nums.length; col++) {
                int n = Integer.parseInt(nums[col]);
                intLine[col] = n;
            }
        }
        reader.close();
        System.out.println(Arrays.deepToString(myArray));
    }

}