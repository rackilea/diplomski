public static int getBit(byte b, int bit)
{
    int power = 1 << bit;
    return (b & power) ? 1 : 0;
}

public static void main(String[] args)
{
    for (int j = 0; j < 8; j++)
    {
        System.out.println(getBit(0x55, j));
    }
}