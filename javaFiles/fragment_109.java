public static void main (String [] args)
{       

    Scanner kb = new Scanner(System.in);    //Allows input from keyboard
    int iMenu;                              //Holds menu 
    System.out.print ("\n\nPress ENTER to continue");
    kb.nextLine();

    int iNum1;                              //Holds user input for number 1
    int iNum2;                              //Holds user input for number 2

    System.out.print("\nPlease enter the first integer: ");
    iNum1 = kb.nextInt();
    System.out.print("\nPlease enter the second integer: ");
    iNum2 = kb.nextInt();

    iMenu = menu(iNum1, iNum2);                         //Calls menu method

}


public static int menu(int iNum1, int iNum2)
{
    /* rest of the menu code */
}