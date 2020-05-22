public void question()
{
 System.out.println("Do you want to exit? [y/n]");  // ask user if they want to quit   with yes or no option
 Scanner q = new Scanner(System.in);
 switch (q.nextLine()) // change nextInt to nextLine, that is the string method 
 {                    // of a string
 case "y" : //change ' ' to " "
 System.out.println ("Thank you and goodbye.");
 break;

 case "n" :  //change ' ' to " "
 InputMenu();
 break;
 default:

 System.err.println ( "Unrecognized option" );
 break;
 }
}