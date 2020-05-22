public String toString()
{
    String s = "";
    for (int r = 0; r != 7 ; r++)
    {
        for (int c = 0; c != 7 ; c++) 
        {
           s += String.format("%02d " ,board[r][c]);
        }
        s += String.format("%n");
    }
        return s;
}