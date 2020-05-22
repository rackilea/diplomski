Scanner s = new Scanner(System.in);
String name = "", address = "";
int cardNo = 0, expirationDate = 0;

while(name == "" || address == "" || cardNo == 0 || expirationDate == 0)
{ 
    System.out.println("Type 'quit' to exit payment");

    //Get Name
    System.out.print("Enter name: ");
    name = s.nextLine();
    if (name.equals("quit")){return;}

    //Get address
    System.out.print("Enter address: ");
    address = s.nextLine();
    if (address.equals("quit")){return;}

    System.out.println("Type '-1' to exit payment");

    //Get card number continually until an integer is entered
    do {
        System.out.print("Enter card number: ");
        try {
            cardNo = Integer.parseInt(s.nextLine());
            break;
        } catch (Exception e) {
            continue;
        }
    } while (true);
    if (cardNo == -1) {return;}

    //Get card expiration date continually until an integer is entered
    do {
        System.out.println("Enter card expiration date: (DDMMYY)");
        try {
            expirationDate = Integer.parseInt(s.nextLine());
            break;
        } catch (Exception e) {
            continue;
        }
    } while (true);
    if (expirationDate == -1){return;}
}