import java.util.Scanner;

public class AdventureTest {

private static Scanner input = new Scanner(System.in);

private static void text(String body) {
    System.out.println("" + body);
}
public static void main(String[] args) {
    char direction,answer = 0;
    do{
    System.out.print("Go n,e,s or w?: ");
    direction = input.nextLine().charAt(0);


        switch( direction )
        {
            case 'n': {
                text("You go North");
                System.out.println("Do you want to continue? (y/n)");
                answer = input.nextLine().charAt(0);
            }
            break;
            case 'e': {
                text("You go East");
                System.out.println("Do you want to continue? (y/n)");
                answer = input.nextLine().charAt(0);
            }
            break;
            case 's':{
                text("You go South");
                System.out.println("Do you want to continue? (y/n)");
                answer = input.nextLine().charAt(0);
            }
            break;
            case 'w':{
                text("You go West");
                System.out.println("Do you want to continue? (y/n)");
                answer = input.nextLine().charAt(0);
            }
            break;
            default:
                text("You fall down a hole!");
                System.exit(0);
        }
    }while(answer == 'y');
    text("Program continues");
}
}