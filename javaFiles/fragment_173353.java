System.out.println("Please choose the input currency:");
Scanner in = new Scanner(System.in);
String choice = in.next(); 

String inType;
switch(choice) {
    case "1":
        inType = "US Dollars";
        break;
    // etc...
    default:
        inType = null;
        System.out.println("Please enter a correct currency type from the list.");
}

System.out.printf("Now enter the input in" + inType);