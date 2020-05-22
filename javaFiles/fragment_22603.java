int number = 0;
int[] count = new int[11];

while(true) {
    try
    {
    number = input.nextInt();
    break;
    } 
    catch (InputMismatchException y)
    {
    System.out.println("You must enter a number.");
    input.nextLine();

    }  
}  


while (number != -1)
{
    try 
    {
        ++count[number];
    } 
    catch (IndexOutOfBoundsException e) 
    {
        System.out.println("Please enter a valid number from the menu.");
    }

    while(true) {
        try
        {
            number = input.nextInt();
            break;
        } 
        catch (InputMismatchException y)
        {
            System.out.println("You must enter a number.");
            input.nextLine();
        } 
    }

}