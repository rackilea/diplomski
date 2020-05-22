public boolean checkInput(String input)
{
    String[] inputOptions = {"a", "b", "c", "d"};
    for(String i : inputOptions)
    {
        if(input.equals(i))
        {
            return true;
        }
    }
    return false;
}

while(!checkInput(choice))
{
    choice = menuInput.nextLine();
}

//After this loop choice will be equal to a b c or d...