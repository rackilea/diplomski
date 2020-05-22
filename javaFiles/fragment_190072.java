import java.util.Scanner;
import java.text.DecimalFormat;
public class Hwk7 {
    private Scanner stdin = new Scanner(System.in);//This needs to be used throughout your class

    //Do these defaults make sense?
    private int males = 0;
    private int females = 0;

    private int totalButterflies  = 0;
    private double sexRatio       = 0;
    private int ratioVariance     = 0;
    private int genderDifferences = 0;
    private int matingPairs       = 0;
    private double growthFactor   = 0;
    private int potentialPopulation = 0;


    public static double getInput(String message, int input) {
        System.out.print(message);
        input = stdin.nextInt();
    }

    public static void main (String[] args) {
        Hwk7 hw = new Hwk7();
        hw.run();
    }

    public void run() {
        System.out.println("\nButterfly Estimator\n");

        getInput("Enter the estimated males population: ", males);
        getInput("Enter the estimated females population: ", females);

        calculateResults();
        printResults();
    }

    public void calculateResults() {
        totalButterflies  = males + females;
        sexRatio          = males / females;
        ratioVariance     = males % females;
        genderDifferences = males - females;
        matingPairs       = males * females;
        growthFactor      = (int)(Math.sqrt(matingPairs));
        ratioFactor       = calculateRatioFactor(growthFactor, sexRatio);
        potentialPopulation = x^2;//where are you getting x from!?
    }

    //Note in your original implementation you calculate this and then immediately
    //change it to the value 'x'! This is clearly wrong.
    public static double calculateRatioFactor(int growthFactor, int sexRatio) {
        if (sexRatio == 0) {
            return Math.sqrt(RATIOVARIANCE);//Ratio variance is never set!
        } else {
            return growthFactor / sexRatio;
        }
    }

    public static void printResults(int males, int females) {
       System.out.println("\nTotal Butterflies: " + totalButterflies );
       System.out.println("Sex Ratio        : " + sexRatio );
       System.out.println("Variance         : " + ratioVariance );
       System.out.println("Gender Differences: " + genderDifferences );
       System.out.println("Possible Mating Pairs: " + matingPairs );
       DecimalFormat oneDigit = new DecimalFormat("#.000");
       System.out.println("Growth Factor: " + growthFactor + oneDigit.format(growthFactor));
       DecimalFormat twoDigit = new DecimalFormat("#.0");
       System.out.println("Ratio Factor: " + ratioFactor + twoDigit.format(ratioFactor));
       DecimalFormat threeDigit = new DecimalFormat("##0");
       System.out.println("Potential Population: " + potentialPopulation + threeDigit.format(potentialPopulation));
    }
}