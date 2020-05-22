public static boolean isFriendly(int number)
{
    int counter = 1;
    int tmpNumber = number;
    while (tmpNumber / 10 >= 1)
    {
        counter ++;
        tmpNumber = tmpNumber / 10;
    }

    boolean check = true;

    for (int i = 1; i <= counter; i++)
    {


        if ((int)(number / Math.pow(10, (counter - i))) % i == 0 && check)
        {
            check = true;
        }
        else
        {
            check = false;
        }



    }
    return check;

}