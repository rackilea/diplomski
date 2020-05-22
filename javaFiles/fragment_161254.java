import java.util.Random;

public class Program7 {

    public static void main(String[] args) {
        Random ran = new Random();
        int[] timesRolled = new int[7];
        for (int i = 0; i < 100; i++) {
            int die = ran.nextInt(6) + 1;
            if (die == 1) {
                timesRolled[1]++;                
            }
            if (die == 2) {
                timesRolled[2]++;               
            }
            if (die == 3) {
                timesRolled[3]++;                
            }
            if (die == 4) {
                timesRolled[4]++;
            }
            if (die == 5) {
                timesRolled[5]++;
            }
            if (die == 6) {
                timesRolled[6]++;
            }
        }
        for (int i = 1; i < timesRolled.length; i++) {
            int j = timesRolled[i];
            String stars = "";
            for (int k = 0; k < j; k++) {
                stars += "*";
            }
            System.out.println("[" + i + "]" + "\t" + stars + " " + timesRolled[i]);
        }
    }
}