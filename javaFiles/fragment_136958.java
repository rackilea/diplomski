import java.util.Scanner;
public class AvgTime {

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        final int SETINEL = 0;
        double sum = 0;
        int count;
        int runnerID;
        for(runnerID = in.nextInt() ; runnerID != 0 ; runnerID = in.nextInt())
        {
            sum = 0;
            for(count = 0 ; count < 8 ; count++)
            {
                double runnerTime = in.nextDouble();
                sum += runnerTime;
            }
            double average = sum / count;
            System.out.println("ID: " + runnerID + "Average: " + average);
        }
    }
}