// i is the start index
for (int i = 0; i < items.length; i++)
{
    // j is the number of elements which should be printed
    for (int j = i; j < items.length; j++)
    {
        // print the array from i to j
        for (int k = i; k <= j; k++)
        {
            System.out.print(items[k]);
        }
        System.out.println();
    }
}