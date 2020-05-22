public static void findLongestPath(int rows, int columns, int[][] elevationMatrix, int[][] adjacencyMatrix)
    {
        int max = 0;
        int cX, cY;

        for (int x = 0; x < rows * columns; x++)
        {   
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (elevationMatrix[i][j] > max && adjacencyMatrix[i][j] == 0)
                    {
                        max = elevationMatrix[i][j]; // possible max, xth iteration
                        cX = i; // store i
                        cY = j; // store j
                    }
                }
            }

            System.out.println(max); // global max, xth iteration
            max = 0;
            // cX and cJ now point to coordinates of global max
            // all the possible max value coordinates are ignored.
            adjacencyMatrix[cX][cJ] = 1;
        }
    }