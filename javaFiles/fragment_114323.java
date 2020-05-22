import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yl1osaB {

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ylesanne 1 RASMUS RIKKEN 25/11/2016");

        while (true) {

            // your code

            if(tulemus < 0 || tulemus > 110) {
                System.out.println("Tulemus is wrong, please try again!");
            }
            else {
                break;
            }
        }

    } // MAIN
}