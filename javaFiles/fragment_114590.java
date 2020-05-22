for (x = 0; x < array[y].length; x++)
        {
            if (array[y][x] <= lowest)
                lowest = array[y][x];

            //if element is on left
            if (x == 0)