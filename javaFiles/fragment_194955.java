List<int[]> output = new ArrayList<int[]>();
if length == 0 
    // the end of the recursion
    for (int i = array[length]; i>=0; i--)
        output.add (i)
else
    // the recursive step
    List<int[]> partialOutput = generateCombinations(array, length - 1)
    for (int i = array[length]; i>=0; i--)
        for (int[] arr : partialOutput)
            output.add(arr + i)
return output