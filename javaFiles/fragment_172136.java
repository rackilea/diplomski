import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main
{

    static List<int[]> getAll(int n, int[] x)
    {
        List<int[]> combinations = new ArrayList<>();

        // First step (0)
        // Create initial combinations, filled with the first number.
        for (int number = 0; number < x.length; number++)
        {
            int[] array = new int[n]; // the final size of each array is already known
            array[0] = x[number]; // fill the first number
            combinations.add(array);
        }

        // In each following step, we add one number to each combination
        for (int step = 1; step < n; step++)
        {
            // Backup the size because we do not want to process
            // the new items that are added by the following loop itself.
            int size = combinations.size();

            // Add one number to the existing combinations
            for (int combination = 0; combination < size; combination++)
            {
                // Add one number to the existing array
                int[] array = combinations.get(combination);
                array[step] = x[0];

                // For all additional numbers, create a copy of the array
                for (int number = 1; number < x.length; number++)
                {
                    int[] copy = Arrays.copyOf(array, array.length);
                    copy[step] = x[number];
                    combinations.add(copy);
                }
            }
        }

        return combinations;
    }

    public static void main(String[] args)
    {
        int[] x = {3, 5, 7};
        int n = 3;

        // Calculate all possible combinations
        List<int[]> combinations = getAll(n, x);

        // Print the result
        for (int[] combination : combinations)
        {
            System.out.println(Arrays.toString(combination));
        }
    }
}