class BitShiftOptimization
{
    public static void main(String args[])
    {
        int blackHole = 0;
        for (int i=0; i<1000000; i++)
        {
            blackHole += testMulti(i);
            blackHole += testShift(i);
        }
        System.out.println(blackHole);

    }

    public static int testMulti(int a)
    {
        int b = a * 256;
        return b;
    }

    public static int testShift(int a)
    {
        int b = a << 8L;
        return b;
    }
}