for (int i = 0; i < total; i++)
{
    int[] moves = new int[n];
    for (int move = 0; move < n; ++move)
    {
        moves[move] = (i / (int) Math.pow(available, move)) % available;
    }
    combinations[i] = moves;
}