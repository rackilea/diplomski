char showChar(String text, int index)
{
    char letter='0';

    if((text.equals(null)))
    {
    System.out.print("Invalid input string. The process"
                          + "terminates");
    }
    else{ 
        if(index<0 || index>=text.length())
        {
            System.out.print("Invalid input for index\n"
                           + "The first character of the text is " + text.charAt(0));
            return letter;
        }
    else{
        if(index>=0 && index<text.length()) 
        {
        System.out.println("The character you asked for is: " + text.charAt(index));
        letter = text.charAt(index);
        return letter;
        }
    }
    }

return letter;
}