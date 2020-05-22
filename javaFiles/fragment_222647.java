public void question()
{
 System.out.println("Do you want to exit? [y/n]");  // ask user if they want to quit   with yes or no option
 Scanner q = new Scanner(System.in);
 switch (q.nextInt()) // here you are assuming that you are reading a int in step 
 {                    // of a string
 case 'y' : // ' ' arent used for strings...
 System.out.println ("Thank you and goodbye.");
 break;

 case 'n' :
 InputMenu();
 break;
 default:

 System.err.println ( "Unrecognized option" );
 break;
 }
}