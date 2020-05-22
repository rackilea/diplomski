private static BigInteger posConst[] = new BigInteger[MAX_CONSTANT+1];
private static BigInteger negConst[] = new BigInteger[MAX_CONSTANT+1]
static 
{
    for (int i = 1; i <= MAX_CONSTANT; i++) 
    {
        int[] magnitude = new int[1];
        magnitude[0] = i;

        posConst[i] = new BigInteger(magnitude,  1);
        negConst[i] = new BigInteger(magnitude, -1);
     }
}