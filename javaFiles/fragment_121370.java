public static int count(int[][] array, int query)
    {
        // nothing to find in an empty array
        if(array.length == 0)
            return 0;

        int countoccurences = 0;
        for (int column = 0; column < array[0].length; column++)
        {
            int low = 0;
            int high = array.length - 1;
            while (low <= high)
            {
                int mid = (low + high) / 2; //Set mid point to be (low + high) divided by 2
                if (array[mid][column] == query)
                {
                    // Check if middle value in each column is equal to the search query
                    for (int row = low; row <= high; row++)
                    {
                        if (array[row][column] == query)
                            countoccurences++; //If it is, increment countoccurences by 1
                    }
                    break;
                }
                else if (array[mid][column] < query)
                {
                    low = mid + 1; //If it is less than query then re-adjust low to be mid index + 1
                }
                else
                {
                    high = mid - 1; //if query is too low, re-adjust high to be mid index - 1
                }
            }

        }
        return countoccurences;
    }