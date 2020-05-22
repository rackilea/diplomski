public class Example
{
    public static void main(String[] args) throws Exception {
        int[] values = {5, 1, 2};
        int smallest = Integer.MAX_VALUE;
        int largest  = Integer.MIN_VALUE;
        for (int value : values) {
            if (value < smallest) {
                smallest = value;
            } else if (value > largest) {
                largest = value;
            }
        }
        System.out.println(smallest + ", " + largest); // 1, 2 -- WRONG
    }
}