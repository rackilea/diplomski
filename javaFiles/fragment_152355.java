import java.util.Random;

public class RandomNumbersNoRepeating {
    public static void main(String[] args) {
        int array[] = new int[10];
        Random random = new Random();

        //Fills the array
        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            int r = 0;
            do {
                found = false;
                r = random.nextInt(10) + 1;
                //Here we check if the number is not on the array yet
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == r) {
                        found = true;
                        break;
                    }
                }
            } while (found);

            array[i] = r;
        }

        //Prints the array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}