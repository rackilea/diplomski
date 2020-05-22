/* Positive modular division. */
public static int pmod(int num, int mod)
{
    num %= mod;
    if(num < 0) num += mod;
    return num;
}