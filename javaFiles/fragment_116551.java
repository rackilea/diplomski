import java.util.Scanner;

public class Main{
    static Scanner in = new Scanner(System.in); //Declared as Static
    private static int getInput(String axis, String point) {

        int coordinate = 0;
        boolean valid = false;

        while(!valid)
        {
            System.out.println("Enter "+ axis +" for " + point +" > ");
            if (in.hasNextInt()){
                coordinate = in.nextInt();
                if (coordinate >= 0 && coordinate <10){

                valid = true;
                }
            }
        }

        return coordinate;
        }
public static void main(String[] args) throws Exception 
{

    int Ai = getInput("i", "A");
    int Aj = getInput("j", "A"); 
    int Bi = getInput("i", "B");
    int Bj = getInput("j", "B");
    in.close(); // close the scanner when your program is about to end
}
}