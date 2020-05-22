import java.util.Arrays;

public class problem1 {
  public static void main(String[] args) {

    int[] sequence = new int[20];

    //Generates 20 Random Numbers in the range 1 to 99
    for(int i = 0; i < sequence.length; i++)
      sequence[i] = (int)(Math.random() * 99 + 1);

    System.out.println("The sequence is: " + Arrays.toString(sequence));

    //Sort the sequence
    Arrays.sort(sequence);

    System.out.println("The sorted sequence is: " + Arrays.toString(sequence));
  }
}