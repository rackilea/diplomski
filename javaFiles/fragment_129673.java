Scanner input=new Scanner(System.in);
int selection = input.nextInt();

while (selection<4)
{
   switch(selection){
        case 1:
           System.out.println("Please enter amount");
           double amount=input.nextDouble(); //object of scanner class
           break;

        case 2:
           System.out.println("Enter ID number"); 
           break;

        case 3:
           System.out.println("Enter amount to be credited");
           break;
      }
      System.out.println("1. Transfer\n2.Check balance\n3.Recharge");
      selection = input.nextInt(); // add this
 }