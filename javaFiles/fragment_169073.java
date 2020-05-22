public static boolean findMatch(char [][]M, int myRow)
{           
        if(myRow < 0)
            return true;            

        for(int c = 0; c < M.length; c++)
        {
            if(M[myRow][c] == 'y' && !isTaken(M, myRow, c))
            {
                M[myRow][c] = 't';
                if (findMatch(M, myRow-1))
                    return true;
                M[myRow][c] = 'y';
            }
        }
        return false;

}