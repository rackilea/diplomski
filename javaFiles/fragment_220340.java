import java.util.Random;

public class random {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random myRandom = new Random();
        int[] numbers = new int[50];
        boolean[] check = new boolean[50];
        int amountFilled = 0;
        int trial;
        while (amountFilled < 50) {
            trial = myRandom.nextInt(50);
            if (!check[trial]) {
                check[trial] = true;
                numbers[amountFilled] = trial;
                amountFilled++;
            }
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(numbers[i]);
        }
    }
}