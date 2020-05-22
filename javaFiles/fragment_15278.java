import java.util.Random;
    public class Main {
        Random randomNum = new Random();
        public static void main(String[] args) throws Exception {
            Main main = new Main();
            for (int i =0; i<20; i++) {
                System.out.println(main.diceRoll());
            }
        }

        public int diceRoll()
        {
            int diceResult = 0;
            int result = randomNum.nextInt(20) + 1;
            diceResult = diceResult + result;
            return diceResult;
        }
    }