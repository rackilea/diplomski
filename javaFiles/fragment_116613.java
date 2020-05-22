public static void printArray(int[] myArray)
{

    System.out.print("[");
    for(int i = 0; i < myArray.length; i++)
    {
        myArray[i] = i + 1;
        if (i > 0)
        {
            System.out.print(", ");
        }
        System.out.print(myArray[i]);
    }
    System.out.println("]");
}