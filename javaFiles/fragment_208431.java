import java.util.Scanner;//Add this line

public class ManyPrints {

    public static void printText() {//no problems here
        System.out.println("In the beginning there were the swamp, the hoe and     Java.");
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("How many?");
        int number = Integer.parseInt(reader.nextLine());
        int i = 1;//it should be i = 1; and not i = 0;
        while (i <= number) {
            i++;
            printText();
        }
    }//done
}