class Diag
{
    public static void main(String[] args) throws java.lang.Exception
    {

        int[][] elements = new int[][] { 
                { 1, 5, 9, 13 }, 
                { 2, 6, 10, 14 }, 
                { 3, 7, 11, 15 }, 
                { 4, 8, 12, 16 } };

        int R = elements.length;
        int C = elements[0].length;

        for (int row = R - 1, col = C - 1; row >= 0 && col >= 0;)
        {
            if (col == C - 1 && row != 0)
            {
                System.out.println(elements[row][col]);
                col = row - 1;
                row = R - 1;
                continue;
            }

            if (row == 0)
            {
                System.out.println(elements[row][col]);
                row = col - 1;
                col = 0;
                continue;
            }

            System.out.print(elements[row][col] + " ");
            row = (row - 1 + R) % R;
            col = (col + 1) % C;
        }

    }
}