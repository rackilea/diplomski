public static void main(String args[])
{
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {2, 3, 1, 0, 5};
    for (int num1 : array1)
    {
        boolean found = false;
        for (int num2 : array2)
        {
            if (num1 == num2)
            {
                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Missing number is " + num1);
        }
    }
}