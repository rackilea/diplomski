public static int ZeroCount (int num)
{
    int zeros = 0;
    for (int i =5; i <= num; i*=5)
        zeros = zeros + (int)Math.floor(num/i);
    return zeros;
}