import java.util.*;

public class Program
{
    public static Scanner rew = new Scanner(System.in);

    public static void main(String[] args) {
        String dec;
        do {
            System.out.println("Input info:");
            String name = stringGetter("Name: ");
            String yearandsec = stringGetter("Year and section: ");
            dec = stringGetter("Enter 1 to continue: ");
        } while(dec.equals("1"));
    }

    public static String stringGetter(String ny){
        System.out.println(ny);
        return rew.nextLine();
    }
}