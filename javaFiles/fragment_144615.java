Scanner userInput = new Scanner(System.in);

System.out.println("Is this word spelled correctly?:" + wordToCheck);
        rightCheck(userInput.next());//send the string rather than the scanner

public boolean rightCheck(String usersAnswer)//convert the parameter type to String
{
    if(usersAnswer == "y")
    {
        //"Correct!"
        //Increment User's Score
    }
    else
    {
        //"Incorrect"
        //Decrement User's Score
    }
}