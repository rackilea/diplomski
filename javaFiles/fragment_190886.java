public static void main(String[] args) throws Exception
    {
        // initialize n
        int n = 4;
        // initialize x to 1 from where our printing will start.
        int x = 1;
        /* We will store our generated numbers in an array.
         * For example, the array after we generate 
         * the numbers would look like:
         * [1,0,0,
            2,3,0,
            4,5,6,
            4,5,6,
            2,3,0,
            1,0,0]
         * 
         * When n = 3, there are going to be 3*2 i.e, n*2 rows.
         * in our case 6 rows. 
         * visualize with the above values.
         * The first n/2 rows will be the numbers we print, 
         * the next n/2 will be the mirror image of the first n/2 rows.
         * no. of columns in each row will be equal to n, in our example:3
         */
        int arr[][] = new int[n*2][n];
        /*
         * Start populating the matrix
         * Each row will contain number of elements eaual to the row number,
         *  so 1st row -> 1 element, 2nd - > 2,.. and so on.
         */
        for(int row=0;row<n;row++)
        {
            int col = 0;
            while(col < row+1)
            {
                arr[row][col] = arr[n*2-row-1][col] = x++;
                col++;
            }
        }
        /*
         * Now our task is just to read out the array.
         * The tricky part is adding the astricks.
         * We notice that row1 will have 1-1 asticks, row2 -> 2-1 astricks ,.. and so on.
         * So in between the numbers while reading out,
         * for each row we maintain the number of astricks.
         */
        for(int i=0;i<arr.length;i++)
        {
            StringBuilder build = new StringBuilder();
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j] > 0)
                {
                    build.append((arr[i][j])).append("*");
                }
            }
            System.out.print(build.delete(build.length()-1,build.length()).toString());
            System.out.println();
        }
    }