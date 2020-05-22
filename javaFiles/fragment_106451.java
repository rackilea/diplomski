private static int[] OddSort(int[] items)
{
    int oddPos, nextEvenPos;
    for (nextEvenPos = 0; 
         nextEvenPos < items.Length && items[nextEvenPos] % 2 == 0;
         nextEvenPos++) { }
    // nextEvenPos is now positioned at the first odd number in the array, 
    // i.e. it is the next place an even number will be placed

    // We already know that items[nextEvenPos] is odd (from the condition of the 
    // first loop), so we'll start looking for even numbers at nextEvenPos + 1
    for (oddPos = nextEvenPos + 1; oddPos < items.Length; oddPos++)
    {
        // If we find an even number
        if (items[oddPos] % 2 == 0)
        {
            // Swap the values
            int temp = items[nextEvenPos];
            items[nextEvenPos] = items[oddPos];
            items[oddPos] = temp;
            // And increment the location for the next even number
            nextEvenPos++;
        }
    }

    return items;
}