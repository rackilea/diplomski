try
{
    int a = keyboard.nextInt();
    verifyAge(a);
}    
catch (InputMismatchException e)
{
    System.out.println("You may only enter integers as an age. Try again.");
    getAge();
}