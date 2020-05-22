import java.util.*;

public class Answer {


    public static void main(String[] args) {

        String name = "";
        System.out.printf("Name of the Story Arc:  ");
        Scanner in = new Scanner(System.in);
        if(in.hasNext()) {
            name = in.nextLine();
        }

        int l = 0;
        System.out.printf("Length of the Story Arc:  ");
        if(in.hasNextInt()) {
            l = in.nextInt();
        }

        System.out.println("Name of the Story Arc: "+name);
        System.out.println("Length of the Story Arc:  "+l);


    }

}