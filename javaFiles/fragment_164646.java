public static void findConsecutive()
    {
        int[] array = {1,2,3,5,6,7,8,10};

        int counter = 1;
        int i = 1;
        for (i = 1; i < array.length; i++)
        {
            if (array[i] == (array[i-1] + 1))
            {
                counter++;
                if (counter == 4)
                {
                    System.out.println("Consecutive elements are at array index: " + (i - 3) + " to " + i);
                    break;
                }
            }
            else
            {
                counter = 1;
            }
        }
    }