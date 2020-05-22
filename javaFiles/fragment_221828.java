public static int[] getNumbersFor(int number)
{
    int firstMax = 0;
    int firstMin = 0;

    int secondMax = 0;
    int secondMin = 0;

    if (number > 100)
    {
        firstMax = 100;

        if (number > 200)
        {
            firstMin = number - 200;
        }
    }

    Random r = new Random();
    int firstRand = r.nextInt(firstMin, firstMax);

    int a = firstRand;

    int temp = number - a;

    if (temp > 100)
    {
        secondMax = 100;
        secondMin = temp - 100;
    }

    int secondRand = r.nextInt(secondMin, secondMax);

    int b = secondRand;

    int c = temp - b;

    return new int[] { a, b, c };
}