if (sc.hasNextInt())
{
    if (sc.nextInt()==pass)
        System.out.println("The password was successfully entered."); 
    else
        System.out.println("The password is wrong.");
} else {
    System.out.println("Password format is incorrect.");
}