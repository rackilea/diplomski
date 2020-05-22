private static int direction = rand();
private static int count;

public static int getMove()
{
    if (count < 3)
    {
        count++;
        return direction;
    }

    count = 0;
    direction = rand();
    return direction;
}

private static int rand()
{
    return (int) (Math.random() * 4); // 0, 1, 2 or 3
}