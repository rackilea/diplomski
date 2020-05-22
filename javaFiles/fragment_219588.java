import java.util.ArrayList;
import java.util.Scanner;

public class ReverseOrderProgram {
    public static void main(String args[]) {

    //create arraylist for lines
    ArrayList<String> lines = new ArrayList<String>();
    //get input

    Scanner sc = new Scanner(System.in);
    System.out.println("Type some text with line breaks, end by \"-1\":");
    String append = "";
    while (sc.hasNextLine()) {
        String input = sc.nextLine();
        if ("-1".equals(input)) {
            break;
        }
        lines.add(input);
    }

    sc.close();
    System.out.println("The current append: ");
    for(String line : lines){
        System.out.print(line + ". ");
    }

    System.out.println("\n\nThe reverse order is:\n");

    for (int i = lines.size()-1; i >=0 ; i--) {
        System.out.println(lines.get(i));
    }
}
}