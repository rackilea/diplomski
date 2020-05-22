public static int PositiveMod(int value, int mod)
{
    return ((value % mod + mod) % mod);
}

int result = PositiveMod(-1, 20); //Returns 19