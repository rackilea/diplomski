import static java.lang.System.*;

public class AtCounter
{
    private String[][] atMat;
    private int totalCount = 0;
    private boolean[][] visited; //used to see if location has been visited before.

    private int rows; // To store rows length
    private int cols; // To store cols length

    public AtCounter(int rows, int cols)
    {
        //size of the matrix
        this.rows = rows;
        this.cols = cols;
        atMat = new String[rows][cols];

        //use nested loops to randomly load the matrix
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++) {
                int num = (int) (Math.random() * 2);
                if(num == 0)
                    atMat[r][c] = "@";
                else
                    atMat[r][c] = "-";
            }

        visited = new boolean[rows][cols];
    }

    /**
    * Used to find out if location is in the 2D Matrix.
    */
    public boolean inBounds(int r, int c)
    {
        return r > -1 && r < rows && c > -1 && c < cols;
    }

    public int countAts(int r, int c)
    {
        //add in recursive code to count up the # of @s connected
        //start checking at spot [r,c]

        if(!inBounds(r,c) || atMat[r][c].equals("-")) // The order here matters
            return 0;

        if(!visited[r][c])
        {
            visited[r][c] = true; // Marks the current cell as visited
            if(atMat[r][c].equals("@"))
            {
                totalCount+=1;

                if(inBounds(r - 1, c))//up
                    countAts(r - 1, c);

                if(inBounds(r + 1, c))//down
                    countAts(r + 1, c);

                if(inBounds(r, c + 1))//right
                    countAts(r , c + 1);

                if(inBounds(r, c  - 1))//left
                    countAts(r, c - 1);
            }
        }
        return totalCount;
    }

}