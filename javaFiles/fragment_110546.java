public static boolean isLucky(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == 7 || array[i] == 13 || array[i] == 18)
            {
                System.out.println("Going to return true");
                return true;
            }
        }
        return false;
    }