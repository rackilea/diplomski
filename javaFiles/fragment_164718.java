import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        //Make arraylist for teams
        List < Integer[] > teamMatches = new ArrayList < > ();

        for (int i = 0; i < 4; i++) {
            // *create new Array for team numbers
            Integer[] teamNums = new Integer[] {1, 2, 3, 4};

            //shuffle array    
            Collections.shuffle(Arrays.asList(teamNums));

            //add array to arraylist
            teamMatches.add(teamNums);

            //print out
            System.out.println(
                teamMatches.get(i)[0] + ", " 
                + teamMatches.get(i)[1] + ", "
                + teamMatches.get(i)[2] + ", "
                + teamMatches.get(i)[3]
            );
        }
        System.out.println("_____________________________");

        //print out entire match array
        for (int n = 0; n < 4; n++) {    
            System.out.println(
                teamMatches.get(n)[0] + ", "
                + teamMatches.get(n)[1] + ", "
                + teamMatches.get(n)[2] + ", "
                + teamMatches.get(n)[3]); 
        }
    }
}