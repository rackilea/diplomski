System.out.println("Is there anymore amounts you want to add?(Y/N): ");
Scanner keyboard = new Scanner(System.in);
char choice = keyboard.next().charAt(0);
choice = Character.toUpperCase(choice);
if (choice == 'Y')
{
    do
    {
        readValidateAmountType();
        readValidateAmount(); 

        System.out.println("Is there anymore amounts you want to add?(Y/N): ");
        choice = keyboard.next().charAt(0);
        choice = Character.toUpperCase(choice);
    }
    while(choice =='Y');
}
Event.displayFinalResults();