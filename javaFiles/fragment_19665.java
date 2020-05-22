boolean validInput = false;

while(!validInput)
{
    System.out.println("ENTER PASSWORD_");

    int guess = in.nextInt();

    if (guess > (getRange() - 1) || guess < (getRange() / 10 ))
    {
        System.out.println("ERROR: INVALID_PASSWORD");
    }
    else
    {
        // this will cause your input loop to terminate
        validInput = true;
    }
}

checkPassword();