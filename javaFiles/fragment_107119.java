import java.util.Random; 



public class Dice {

    private Random random;

    public Dice() {

        random = new Random();
    }  

    public int throwDice() {

        int num = 0;

        while(num == 0)  // Dice doesn't have a zero, so keep looping unless dice has a zero.
            num = random.nextInt(7);  // returns a random number between 0 - 6

        return num;
    }
}