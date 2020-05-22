public static int[] makeTransaction(int[] trans, int amount)
{
    int[] new_trans = Arrays.copyOf(trans, trans.length + 1);
    new_trans[trans.length] = amount;

    return new_trans;
}