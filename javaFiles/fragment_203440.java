public static void main(String[] args) throws Exception
{

    InputStreamReader ui = new InputStreamReader (System.in);
    BufferedReader inputReader = new BufferedReader(ui);
    String membership, tyreRental,parking;
    double x = 0d;
    do
    {
        System.out.println("Select Membership Type: (Gold/Silver/Bronze)");
        membership = inputReader.readLine();

        if (membership.equals("Gold"))
            System.out.println("Gold Membership Selected: £" + (x = 750));
        else if (membership.equals("Silver"))
            System.out.println("Silver Membership Selected: £" + (x = 450));
        else if (membership.equals("Bronze"))
            System.out.println("Bronze Membership Selected: £" + (x = 250));
        else{
            System.out.println("Invalid Membership");
            continue;
        }
        break;
    }while(true);

    do{
        System.out.println("Do you require snow tyre rental? (yes/no)");
        tyreRental = inputReader.readLine();

        if (tyreRental.equals("yes"))
            System.out.println("The total so far with tyre rental: £" + (x = x * 1.1));
        else if (tyreRental.equals("no"))
            System.out.println("The total so far without tyre rental: £" + x);
        else{ System.out.println("Invalid response"); continue;}
        break;
    }while(true);

    do{
        System.out.println("Would you like to reserve parking? (yes/no)");
        parking = inputReader.readLine();

        if (parking.equals("yes"))
            System.out.println("Membership total: £" + (x = x * 1.08));
        else if (parking.equals("no"))
            System.out.println("Membership total: £" + x);
        else {System.out.println("Invalid response"); continue;}
        break;
    }while(true);
}