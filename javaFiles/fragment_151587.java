int[] input = {10, 20, 30, 40, 50};    // input array
int k = 3;                             // sequence length   

List<int[]> subsets = new ArrayList<>();

int[] s = new int[k];                  // here we'll keep indices 
                                       // pointing to elements in input array

if (k <= input.length) {
    // first index sequence: 0, 1, 2, ...
    for (int i = 0; (s[i] = i) < k - 1; i++);  
    subsets.add(getSubset(input, s));
    for(;;) {
        int i;
        // find position of item that can be incremented
        for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); 
        if (i < 0) {
            break;
        }
        s[i]++;                    // increment this item
        for (++i; i < k; i++) {    // fill up remaining items
            s[i] = s[i - 1] + 1; 
        }
        subsets.add(getSubset(input, s));
    }
}

// generate actual subset by index sequence
int[] getSubset(int[] input, int[] subset) {
    int[] result = new int[subset.length]; 
    for (int i = 0; i < subset.length; i++) 
        result[i] = input[subset[i]];
    return result;
}