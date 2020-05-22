import java.util.Random;
public class Decks {
    public static void main(String[] args) {

        Random myRandom = new Random();

        int[] num = new int[53];

        boolean[] check = new boolean[53];
        int all = 0;
        int ranNum;

        while (all < 53) {
            ranNum = myRandom.nextInt(53);
            if (!check[ranNum]) {
                check[ranNum] = true;
                num[all] = ranNum;
                all++;
            }
        }
        for (int i = 0; i < 53; i++) {
            System.out.println(num[i]);
        }
    }
}