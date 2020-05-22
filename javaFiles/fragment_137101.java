public int getNumDigits()
{
    int numDigits = 0;
    for (int count = 0; count < wordArray.length; count++)
    {
        if (Character.isDigit(wordArray[count]))
            numDigits++;
    }
    return numDigits;
}