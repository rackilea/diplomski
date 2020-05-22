import java.util.Scanner;

public class InputData {

   public static void main(String[] args) {

        /*String stdName;
        int mathMarks;
        int engMark;`enter code here`
        int sciMark;*/

        Scanner input = new Scanner(System.in);
        String stdName = input.nextLine();
        int mathMark = input.nextInt();
        int engMark = input.nextInt();
        System.out.println("Insert Name Value");
    }

    public static int grade () {
        if ((mathMark + engMark ) < 50) {
            return 1;
        } else  {
            return 2;    
        }
    }    
}