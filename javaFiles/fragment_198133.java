private static int cheat = 0;

private static boolean goForBiggerResource ()
{
    cheat = (cheat + 1) % 4;
    return cheat == 0;
}