public class Example {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    final int range = 10;
    int[] numbers = new int[range + 1];
    int sum = 0;
    final int noOfOccurances = 4;
    final int size = range * noOfOccurances;
    Arrays.fill(numbers, 0);
    Random generator = new Random();
    List<Integer> numbersArray = new ArrayList<>();
    while (sum != size) {
        int randomNumber = generator.nextInt(range) + 1;
        if (numbers[randomNumber] != noOfOccurances) {
            numbers[randomNumber]++;
            sum++;
            numbersArray.add(randomNumber);
        }
    }
    System.out.println(numbersArray);
}
}