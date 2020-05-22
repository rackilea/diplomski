import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        System.out.println("Enter string: ");
        Scanner input = new Scanner(System.in);
        List<String> lines = new ArrayList<> ();
        String line = null;
        while (!(line = input.nextLine()).isEmpty()) {
            lines.add(line);
        }
        StringBuilder myOriginalString = new StringBuilder();
        for (String s : lines) {
            myOriginalString.append(s);
            myOriginalString.append(" ");
            myOriginalString.append("\n");
        }
        String originalString = myOriginalString.toString();
        System.out.println("Original string: \n"  + originalString);
        converter(originalString);
    }

    public static void converter(String inputString){
        String refinedString = inputString.replaceAll("\\s+","");
        System.out.println();
        System.out.println("Refined string: " + refinedString);
    }

}