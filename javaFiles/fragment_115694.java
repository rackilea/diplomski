import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Try {

    public static void main(String[] args) throws IOException {

        Map<String, List<String>> storage = new HashMap<>();

        // !important! initialize scanner with a file, not with a filename
        Scanner input = new Scanner(new File("inputemails.txt"));

        // a new pattern to get the subdomain out of an eMail-address
        Pattern subdomainPattern = Pattern
                .compile(".*\\@([^\\.]+(?:\\.[^\\.]+)*)(?:\\.[^\\.]+){2,}");

        // I used your pattern to find any eMail-address
        Pattern eMailPattern = Pattern
                .compile("([\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Za-z]{2,4})");

        // Use Scanner to find each match in your input file
        String eMailAddress;
        while ((eMailAddress = input.findWithinHorizon(eMailPattern, 0)) != null) {

            // determine the subdomain of this eMail-address
            String subdomain;
            Matcher matcher = subdomainPattern.matcher(eMailAddress);
            if (matcher.matches()) {
                subdomain = matcher.group(1);
            } else {
                subdomain = "no subdomain";
            }

            // get/create list of all eMail-addresses for this subdomain from
            // map
            List<String> listOfEMailAddresesToThisSubdomain = storage
                    .get(subdomain);
            if (listOfEMailAddresesToThisSubdomain == null) {
                listOfEMailAddresesToThisSubdomain = new ArrayList<>();
                storage.put(subdomain, listOfEMailAddresesToThisSubdomain);
            }

            // add this eMail-address to list
            listOfEMailAddresesToThisSubdomain.add(eMailAddress);
        }

        input.close();

        System.out.println("Choose subdomain");
        System.out
                .println("0.none 1.art 2. chee 3. chem 4. coe 5. cs 6. egr 7. polsci");

        // read, what the user will choose
        char userInput = (char) System.in.read();

        // map the number to a subdomain name
        String chosenDomain;
        switch (userInput) {
        case '0':
            chosenDomain = null;
            break;
        case '1':
            chosenDomain = "art";
            break;
        case '2':
            chosenDomain = "chee";
            break;
        case '3':
            chosenDomain = "chem";
            break;
        case '4':
            chosenDomain = "coe";
            break;
        case '5':
            chosenDomain = "cs";
            break;
        case '6':
            chosenDomain = "egr";
            break;
        case '7':
            chosenDomain = "polsci";
            break;
        default:
            System.out.println("invalid choice");
            return;
        }

        // open file for writing
        PrintWriter output = new PrintWriter("outputemails.txt");

        // use the chosen subdomain name as a key to our storage map. The result
        // will be the list of all eMail-Addresses of that subdomain (or null).
        List<String> eMailAddresses = storage.get(chosenDomain);

        // make output
        if (eMailAddresses == null) {
            System.out.println("no addresses");
        } else {
            for (String eMail : eMailAddresses) {
                System.out.println(eMail);
            }
        }
        output.close();
    }
}