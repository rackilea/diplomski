import java.util.Random;

public class TestClass1 {
static public Random num = new Random(System.currentTimeMillis());

public static void main(String[] args) { 
    int points = 0;
    while (points < 100) {
    int[] scoreInfo = diceGen();
    System.out.println(scoreInfo[0]);
    System.out.println(scoreInfo[1]);
    points += 1;
    }
}

public static int[] diceGen() {        
    int dice1 = num.nextInt(6)+1;
    int dice2 = num.nextInt(6)+1;
    int[] numbers = {dice1, dice2};
    return numbers;     

}


}