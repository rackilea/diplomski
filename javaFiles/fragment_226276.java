import java.util.Arrays;
public class Main {
    public static void main(String args[]) {
        String times[] = {"2:30","00:00", "00:12", "24:00", "23:55"};/*input times*/
        int countTime = times.length;
        int sortedTimes[] = new int[countTime];/*will hold sorted times*/

        for (int i = 0; i < countTime; i++) {/*convert 'HH:mm' to integer minute*/
            int t = Integer.valueOf(times[i].split(":")[0])*60 
                    + Integer.valueOf(times[i].split(":")[1]);
            sortedTimes[i] = t;
        }
        Arrays.sort(sortedTimes);/*sort times*/         
        /*variables to hold the result*/
        int minDiff = 1440;
        int minT1 = 1440;
        int minT2 = 1440;

        for (int i = 0; i < countTime; i++) {
            int curr = sortedTimes[i];
            int prev = sortedTimes[(countTime+i-1)%countTime];
            int diffPrev = Math.abs(curr - prev) < 1440 - Math.abs(curr - prev ) ? 
                    Math.abs(curr - prev) :  1440 - Math.abs(curr - prev  ) ; 
            if (minDiff > diffPrev) {
                    minDiff = diffPrev;
                    minT1 = prev;
                    minT2 = curr;                   
            }
        }       
        System.out.println("Minimum diff in minute: " + minDiff 
                + " between " + (minT1/60 + ":" + minT1%60) 
                + " and " + (minT2/60 + ":" + minT2%60));

    }
}