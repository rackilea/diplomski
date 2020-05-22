private int[][] copyBoard(int[][] state)
{
    int[][] returnArray = new int[rows][columns];
    for (int i = 0, j = 0; i*j < PUZZLE_SIZE; i++, j++)
    {
        // deep copy of row:
        returnArray[i] = Arrays.copyOf(state[i], state[i].length);
    }
    return returnArray;
}