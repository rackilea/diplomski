public class Example
{
    public static void main(String[] args) throws Exception {
        int[] values = {5, 1, 2};
        int smallest = values[0];
        int largest  = values[0];
        for (int n = 1; n < values.length; ++n) {
            int value = values[n];
            if (value < smallest) {
                smallest = value;
            } else if (value > largest) {
                largest = value;
            }
        }
        System.out.println(smallest + ", " + largest); // 1, 5
    }
}