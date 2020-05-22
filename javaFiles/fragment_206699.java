static void printAllKLengthRec(char[] set, 
                            String prefix, 
                            int n, int k, int validCount)
{

    // Base case: k is 0, print prefix
    if (k == 0) 
    {
        System.out.println(prefix);
        return;
    }

    // One by one add all valid characters and recursively call for k equals to k-1
    for (int i = 0; i < validCount; ++i)
    {

        // Next character of input added
        String newPrefix = prefix + set[i]; 

        // increment the valid count if all characters up till then have already
        // appeared and there are characters that have not yet appeared
        // (i.e. validCount < n)
        int newValidCount = (i == (validCount - 1)) && (validCount < n) ?
            validCount + 1 :
            validCount;

        // k is decreased, because we have added a new character
        printAllKLengthRec(set, newPrefix, 
                                n, k - 1, newValidCount); 
    }
}