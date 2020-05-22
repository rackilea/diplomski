public void calcExponents(int max)
{
    int resultThree = 3;
    int resultFive = 5;

    while(resultThree < max)
    {
        System.out.println(resultThree);
        if(resultFive < max)
        {
            System.out.println(resultFive);
        }

        resultThree *= 3;
        resultFive *= 5;
    }
}