index = Random.nextInt(50);  // random number between 0-49

System.out.println("Enter the capital for " + states[index] + ":");
String answer = in.nextLine();


//Precondition: the arrays for the capitals and state must be in the correct order for
//this to work properly
if ( capitals[index].equalsIgnoreCase( answer ) )
{
    return true;
}
else
{
    return false;
}