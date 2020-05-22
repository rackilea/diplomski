import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String filename = "policy.txt";
        Scanner input = null;
        double itemAmount = 0;
        int policyCount = 0;

        input = new Scanner(new File(filename));
        while (input.hasNext())
        {
            String read = input.nextLine();
            String clean = read.replaceAll("\\P{Print}", "");

            char policyType = clean.charAt(59);

            if (policyType == 'A' || policyType == 'M')
            {
                policyCount++;
                itemAmount += Character.getNumericValue((clean.charAt(24)));
            }
        }
        input.close();
        System.out.println(policyCount);
        System.out.println(itemAmount);            
    }
}