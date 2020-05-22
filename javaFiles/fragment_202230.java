import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
public class Reading {
private static Scanner n;

public static void main(String[] args) throws Exception
{
    File files = new File("samples.txt");
    n = new Scanner(files);
    String data;
    while(n.hasNextLine() && !(data = n.nextLine()).equals(""))
    {
        StringTokenizer st = new StringTokenizer(data);

        if(st.countTokens() >= 4) {
            String firstName = (String) st.nextElement();        
            String mi = (String) st.nextElement();
            String lastName = (String) st.nextElement();
            int score = Integer.parseInt( (String) st.nextElement());
            System.out.println(
            firstName + " " + mi + " " + lastName + " " + score);

        } else {
            System.err.println("This line is malformed!");
        }
    }

    n.close();
}

}