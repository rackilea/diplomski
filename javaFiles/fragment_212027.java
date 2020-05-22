import java.util.Random;
public class hw {

       public static void main(String[] args) {

            boolean[] pack = new boolean[52];
            int[] cards = new int[5];

            for (int i = 0; i < pack.length - 1; i++) 
            {
                System.out.print(pack[i] + " | ");         
            }

            System.out.println();

            Random give = new Random();

            for (int i = 0; i < cards.length; i++) {
                do
                {
                    cards[i] = give.nextInt(5); 
                }
                while ( pack[cards[i]] );

                pack[cards[i]] = true;                 
                System.out.println(cards[i]);
            }

            for (int i = 0; i < pack.length - 1; i++) 
            {
                System.out.print(pack[i] + " | ");         
            }     
       }

}