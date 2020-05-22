for (int j = 1; j <= 5; j++)
{
    for (int i = 0; i < myArray.length; i++)
         {
             System.out.print(array[i] * j + " ");
             if (i == myArray.length - 1) 
                {
                    System.out.println();
                }
         }
    j++;
}