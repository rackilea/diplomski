// Need to import Random
import java.util.Random;

public class Alfabhto {

    String[] gramata ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    // This neesd to be final for Numbers to access it
    final int[][] pinakas = new int[3][6];

    // There's no reason for Numbers to be public, or to extend Alfabhto, or in
    // fact to be a class at all. Recommend making it a static method within
    // Alfabhto (in which case gramata and pinakas must also be static), or an
    // instance method if appropriate (in which case pinaka does not need to be
    // final anymore, though you might leave it that way if you never
    // intend to replace the array with a different one.
    // Also recommend making that method (static or instance) a  private method.
    public class Numbers extends Alfabhto {
        public Numbers() {
            // Create this once and reuse it
            Random rand = new Random();

            // Note using <, not <=, on the loops
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    pinakas[i][j] = rand.nextInt(38) - 12;
                    System.out.println(pinakas[i][j]);
                }
            }
        }
    }

    // Since Numbers is an inner class, we need to be able to create instances of Alfabhto
    private Alfabhto() {
    }

    // We need something in Alfabhto to run the Numbers constructor    
    private void run() {
        // Run the code in the Numbers constructor
        new Numbers();
    }

    public static void main(String[] args) {
        /* None of this does anything, presumably you'll use it later...
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an alphanumeric combination");
        String fail = s.nextLine();
        */
        // Run our run method, which will run the code in the Numbers constructor
        new Alfabhto().run();
    }
}