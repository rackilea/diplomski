public boolean getTest()
{
    index = 0;
    while (index < numbers.length)
        if (number != numbers[index])
            index++;
        else
            return true;
    return false;
}