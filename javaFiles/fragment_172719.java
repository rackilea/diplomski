import java.util.Scanner;

public class Qty_Of_Musicians_With_Details {

    public static void main(String[] args) {

        //Variables
        int qty_OfMember;

        //my scanner
        Scanner userInput = new Scanner(System.in);

        System.out.println("input number members");
        //read and store user input
        qty_OfMember = userInput.nextInt();

        if (qty_OfMember <= 8) {
            String[] musician_FirstName = new String[qty_OfMember];
            String[] musician_LastName = new String[qty_OfMember];
            String[] musician_Instrument = new String[qty_OfMember];
            //Using FOR LOOP
            for (int i = 0; i < qty_OfMember; i++) {
                //ask for member Full Name
                System.out.println("enter member# " + i + " full name");
                //read and store firstname
                musician_FirstName[i] = userInput.next();
                //read and store lastname
                musician_LastName[i] = userInput.next();
                //Ask for member instrument
                System.out.println("member instrument");
                //Read and store member instrument
                musician_Instrument[i] = userInput.next();
            }

            //print out members names,last_names and instruments  
            System.out.println("\n\n----------------------------------------");
            System.out.println("Details");
            System.out.println("----------------------------------------");
            for (int i = 0; i < qty_OfMember; i++) {
                System.out.println(i + 1 + "\nfirst name: " + musician_FirstName[i] + "\nLast name: " + musician_LastName[i] + "\ninstrument: " + musician_Instrument[i] + "\n");
            }
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Sorry but studio can accept max 8 musicians");
        }
        //closing Scanner
        userInput.close();
    }
}